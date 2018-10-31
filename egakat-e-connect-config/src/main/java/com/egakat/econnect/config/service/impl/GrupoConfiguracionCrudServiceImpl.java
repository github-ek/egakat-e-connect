package com.egakat.econnect.config.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.config.domain.GrupoConfiguracion;
import com.egakat.econnect.config.dto.GrupoConfiguracionDto;
import com.egakat.econnect.config.repository.GrupoConfiguracionRepository;
import com.egakat.econnect.config.service.api.GrupoConfiguracionCrudService;

import lombok.val;

@Service
public class GrupoConfiguracionCrudServiceImpl extends CrudServiceImpl<GrupoConfiguracion, GrupoConfiguracionDto, Long>
		implements GrupoConfiguracionCrudService {

	@Autowired
	private GrupoConfiguracionRepository repository;

	@Override
	protected GrupoConfiguracionRepository getRepository() {
		return repository;
	}

	@Override
	protected GrupoConfiguracionDto asModel(GrupoConfiguracion entity) {
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
	protected GrupoConfiguracionDto newModel() {
		return new GrupoConfiguracionDto();
	}

	@Override
	protected GrupoConfiguracion mergeEntity(GrupoConfiguracionDto model, GrupoConfiguracion entity) {

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected GrupoConfiguracion newEntity() {
		return new GrupoConfiguracion();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<GrupoConfiguracionDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}