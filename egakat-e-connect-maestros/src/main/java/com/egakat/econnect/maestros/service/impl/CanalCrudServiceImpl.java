package com.egakat.econnect.maestros.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Canal;
import com.egakat.econnect.maestros.dto.CanalDto;
import com.egakat.econnect.maestros.repository.CanalRepository;
import com.egakat.econnect.maestros.service.api.CanalCrudService;

import lombok.val;

@Service
@Transactional(readOnly = true)
public class CanalCrudServiceImpl extends CrudServiceImpl<Canal, CanalDto, Long> implements CanalCrudService {
	@Autowired
	private CanalRepository repository;

	@Override
	protected CanalRepository getRepository() {
		return repository;
	}

	@Override
	protected CanalDto asModel(Canal entity) {
		val result = newModel();
		mapModel(entity, result);

		result.setCodigo(entity.getCodigo());
		result.setNombre(entity.getNombre());
		result.setDescripcion(entity.getDescripcion());
		result.setPredeterminado(entity.isPredeterminado());
		result.setOrdinal(entity.getOrdinal());
		result.setActivo(entity.isActivo());

		return result;
	}

	@Override
	protected CanalDto newModel() {
		return new CanalDto();
	}

	@Override
	protected Canal mergeEntity(CanalDto model, Canal entity) {

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setPredeterminado(model.isPredeterminado());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Canal newEntity() {
		return new Canal();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<CanalDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}