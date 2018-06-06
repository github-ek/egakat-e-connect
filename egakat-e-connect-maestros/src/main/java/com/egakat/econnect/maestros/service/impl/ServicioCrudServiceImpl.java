package com.egakat.econnect.maestros.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Servicio;
import com.egakat.econnect.maestros.dto.ServicioDto;
import com.egakat.econnect.maestros.repository.ServicioRepository;
import com.egakat.econnect.maestros.service.api.ServicioCrudService;

import lombok.val;

@Service
public class ServicioCrudServiceImpl extends CrudServiceImpl<Servicio, ServicioDto, Long>
		implements ServicioCrudService {
	@Autowired
	private ServicioRepository repository;

	@Override
	protected ServicioRepository getRepository() {
		return repository;
	}

	@Override
	protected ServicioDto asModel(Servicio entity) {
		// @formatter:off
		val result = ServicioDto
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
	protected Servicio asEntity(ServicioDto model, Servicio entity) {

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Servicio newEntity() {
		return new Servicio();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<ServicioDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}