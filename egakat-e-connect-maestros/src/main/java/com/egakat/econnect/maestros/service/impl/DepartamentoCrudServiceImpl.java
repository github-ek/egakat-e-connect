package com.egakat.econnect.maestros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Departamento;
import com.egakat.econnect.maestros.dto.DepartamentoDto;
import com.egakat.econnect.maestros.repository.DepartamentoRepository;
import com.egakat.econnect.maestros.repository.PaisRepository;
import com.egakat.econnect.maestros.service.api.DepartamentoCrudService;

import lombok.val;

@Service
public class DepartamentoCrudServiceImpl extends CrudServiceImpl<Departamento, DepartamentoDto, Long>
		implements DepartamentoCrudService {

	@Autowired
	private DepartamentoRepository repository;

	@Autowired
	private PaisRepository paisRepository;

	@Override
	protected DepartamentoRepository getRepository() {
		return repository;
	}

	@Override
	protected DepartamentoDto asModel(Departamento entity) {
		// @formatter:off
		val result = DepartamentoDto
				.builder()
				.id(entity.getId())
				.idPais(entity.getPais().getId())
				.codigo(entity.getCodigo())
				.nombre(entity.getNombre())
				.nombreAlterno(entity.getNombreAlterno())
				.cx(entity.getCx())
				.cy(entity.getCy())
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
	protected Departamento asEntity(DepartamentoDto model, Departamento entity) {
		val pais = paisRepository.getOne(model.getIdPais());

		entity.setPais(pais);
		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setNombreAlterno(model.getNombreAlterno());
		entity.setCx(model.getCx());
		entity.setCy(model.getCy());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Departamento newEntity() {
		return new Departamento();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<DepartamentoDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}

	@Override
	public List<DepartamentoDto> findAllByPaisId(long pais) {
		val entities = getRepository().findAllByPaisId(pais);
		val result = asModels(entities);
		return result;
	}
}