package com.egakat.econnect.conciliaciones.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.conciliaciones.domain.EstadoConciliacion;
import com.egakat.econnect.conciliaciones.dto.EstadoConciliacionDto;
import com.egakat.econnect.conciliaciones.repository.EstadoConciliacionRepository;
import com.egakat.econnect.conciliaciones.service.api.EstadoConciliacionCrudService;

import lombok.val;

@Service
public class EstadoConciliacionCrudServiceImpl extends CrudServiceImpl<EstadoConciliacion, EstadoConciliacionDto, Long>
		implements EstadoConciliacionCrudService {

	@Autowired
	private EstadoConciliacionRepository repository;

	@Override
	protected EstadoConciliacionRepository getRepository() {
		return repository;
	}

	@Override
	protected EstadoConciliacionDto asModel(EstadoConciliacion entity) {
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
	protected EstadoConciliacionDto newModel() {
		return new EstadoConciliacionDto();
	}

	@Override
	protected EstadoConciliacion mergeEntity(EstadoConciliacionDto model, EstadoConciliacion entity) {

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected EstadoConciliacion newEntity() {
		return new EstadoConciliacion();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<EstadoConciliacionDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}