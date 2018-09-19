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
		// @formatter:off
		val result = UnidadMedidaDto
				.builder()
				.id(entity.getId())
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