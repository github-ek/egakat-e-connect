package com.egakat.econnect.maestros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.TipoRemesa;
import com.egakat.econnect.maestros.dto.TipoRemesaDto;
import com.egakat.econnect.maestros.repository.TipoRemesaRepository;
import com.egakat.econnect.maestros.repository.UnidadNegocioRepository;
import com.egakat.econnect.maestros.service.api.TipoRemesaCrudService;

import lombok.val;

@Service
public class TipoRemesaCrudServiceImpl extends CrudServiceImpl<TipoRemesa, TipoRemesaDto, Long>
		implements TipoRemesaCrudService {

	@Autowired
	private TipoRemesaRepository repository;

	@Autowired
	private UnidadNegocioRepository unidadNegocioRepository;

	@Override
	protected TipoRemesaRepository getRepository() {
		return repository;
	}

	@Override
	protected TipoRemesaDto asModel(TipoRemesa entity) {
		// @formatter:off
		val result = TipoRemesaDto
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
	protected TipoRemesa asEntity(TipoRemesaDto model, TipoRemesa entity) {
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
	protected TipoRemesa newEntity() {
		return new TipoRemesa();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<TipoRemesaDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}

	@Override
	public List<TipoRemesaDto> findAllByUnidadNegocioId(long unidadNegocio) {
		val entities = getRepository().findAllByUnidadNegocioId(unidadNegocio);
		val result = asModels(entities);
		return result;
	}
}