package com.egakat.econnect.maestros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.SubestadoInventario;
import com.egakat.econnect.maestros.dto.SubestadoInventarioDto;
import com.egakat.econnect.maestros.repository.SubestadoInventarioRepository;
import com.egakat.econnect.maestros.service.api.SubestadoInventarioCrudService;

import lombok.val;

@Service
public class SubestadoInventarioCrudServiceImpl extends
		CrudServiceImpl<SubestadoInventario, SubestadoInventarioDto, String> implements SubestadoInventarioCrudService {
	@Autowired
	private SubestadoInventarioRepository repository;

	@Override
	protected SubestadoInventarioRepository getRepository() {
		return repository;
	}

	@Override
	protected SubestadoInventarioDto asModel(SubestadoInventario entity) {
		val result = newModel();

		result.setId(entity.getId());
		result.setVersion(entity.getVersion());
		result.setCreadoPor(entity.getCreadoPor());
		result.setFechaCreacion(entity.getFechaCreacion());
		result.setModificadoPor(entity.getModificadoPor());
		result.setFechaModificacion(entity.getFechaModificacion());

		result.setNombre(entity.getNombre());
		result.setDescripcion(entity.getDescripcion());
		result.setOrdinal(entity.getOrdinal());
		result.setActivo(entity.isActivo());

		return result;
	}

	@Override
	protected SubestadoInventarioDto newModel() {
		return new SubestadoInventarioDto();
	}
	
	@Override
	protected SubestadoInventario mergeEntity(SubestadoInventarioDto model, SubestadoInventario entity) {

		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected SubestadoInventario newEntity() {
		return new SubestadoInventario();
	}
}