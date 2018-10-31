package com.egakat.econnect.maestros.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.UnidadMedida;
import com.egakat.econnect.maestros.dto.UnidadMedidaDto;
import com.egakat.econnect.maestros.repository.UnidadMedidaRepository;
import com.egakat.econnect.maestros.service.api.UnidadMedidaCrudService;

import lombok.val;

@Service
public class UnidadMedidaCrudServiceImpl extends CrudServiceImpl<UnidadMedida, UnidadMedidaDto, Long>
		implements UnidadMedidaCrudService {
	@Autowired
	private UnidadMedidaRepository repository;

	@Override
	protected UnidadMedidaRepository getRepository() {
		return repository;
	}

	@Override
	protected UnidadMedidaDto asModel(UnidadMedida entity) {
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
	protected UnidadMedidaDto newModel() {
		return new UnidadMedidaDto();
	}

	@Override
	protected UnidadMedida mergeEntity(UnidadMedidaDto model, UnidadMedida entity) {

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected UnidadMedida newEntity() {
		return new UnidadMedida();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<UnidadMedidaDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}