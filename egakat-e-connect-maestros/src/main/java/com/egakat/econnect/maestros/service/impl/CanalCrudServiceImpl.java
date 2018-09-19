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
		// @formatter:off
		val result = CanalDto
				.builder()
				.id(entity.getId())
				.codigo(entity.getCodigo())
				.nombre(entity.getNombre())
				.descripcion(entity.getDescripcion())
				.predeterminado(entity.isPredeterminado())
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