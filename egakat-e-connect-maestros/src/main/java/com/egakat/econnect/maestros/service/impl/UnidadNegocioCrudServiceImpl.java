package com.egakat.econnect.maestros.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.UnidadNegocio;
import com.egakat.econnect.maestros.dto.UnidadNegocioDto;
import com.egakat.econnect.maestros.repository.UnidadNegocioRepository;
import com.egakat.econnect.maestros.service.api.UnidadNegocioCrudService;

import lombok.val;

@Service
public class UnidadNegocioCrudServiceImpl extends CrudServiceImpl<UnidadNegocio, UnidadNegocioDto, Long>
		implements UnidadNegocioCrudService {
	@Autowired
	private UnidadNegocioRepository repository;

	@Override
	protected UnidadNegocioRepository getRepository() {
		return repository;
	}

	@Override
	protected UnidadNegocioDto asModel(UnidadNegocio entity) {
		val result = newModel();
		mapModel(entity, result);

		result.setCodigo(entity.getCodigo());
		result.setNombre(entity.getNombre());
		result.setDescripcion(entity.getDescripcion());
		result.setOrdinal(entity.getOrdinal());
		result.setActivo(entity.isActivo());

		return result;
	}
	
	@Override
	protected UnidadNegocioDto newModel() {
		return new UnidadNegocioDto();
	}

	@Override
	protected UnidadNegocio mergeEntity(UnidadNegocioDto model, UnidadNegocio entity) {

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected UnidadNegocio newEntity() {
		return new UnidadNegocio();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<UnidadNegocioDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}