package com.egakat.econnect.maestros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.LineaNegocio;
import com.egakat.econnect.maestros.dto.LineaNegocioDto;
import com.egakat.econnect.maestros.repository.LineaNegocioRepository;
import com.egakat.econnect.maestros.repository.UnidadNegocioRepository;
import com.egakat.econnect.maestros.service.api.LineaNegocioCrudService;

import lombok.val;

@Service
public class LineaNegocioCrudServiceImpl extends CrudServiceImpl<LineaNegocio, LineaNegocioDto, Long>
		implements LineaNegocioCrudService {

	@Autowired
	private LineaNegocioRepository repository;

	@Autowired
	private UnidadNegocioRepository unidadNegocioRepository;

	@Override
	protected LineaNegocioRepository getRepository() {
		return repository;
	}

	@Override
	protected LineaNegocioDto asModel(LineaNegocio entity) {
		// @formatter:off
		val result = LineaNegocioDto
				.builder()
				.id(entity.getId())
				.idUnidadNegocio(entity.getUnidadNegocio().getId())
				.codigo(entity.getCodigo())
				.nombre(entity.getNombre())
				.descripcion(entity.getDescripcion())
				.ordinal(entity.getOrdinal())
				.activo(entity.isActivo())
				.version(entity.getVersion())
				.creadoPor(entity.getCreadoPor())
				.fechaCreacion(entity.getFechaCreacion())
				.modificadoPor(entity.getModificadoPor())
				.fechaModificacion(entity.getFechaModificacion())

				.build();
		// @formatter:on
		return result;
	}

	@Override
	protected LineaNegocio mergeEntity(LineaNegocioDto model, LineaNegocio entity) {
		val unidadNegocio = unidadNegocioRepository.getOne(model.getIdUnidadNegocio());

		entity.setUnidadNegocio(unidadNegocio);
		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected LineaNegocio newEntity() {
		return new LineaNegocio();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<LineaNegocioDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}

	@Override
	public List<LineaNegocioDto> findAllByUnidadNegocioId(long unidadNegocio) {
		val entities = getRepository().findAllByUnidadNegocioId(unidadNegocio);
		val result = asModels(entities);
		return result;
	}
}