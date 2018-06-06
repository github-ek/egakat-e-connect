package com.egakat.econnect.maestros.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.TipoRuta;
import com.egakat.econnect.maestros.dto.TipoRutaDto;
import com.egakat.econnect.maestros.repository.TipoRutaRepository;
import com.egakat.econnect.maestros.service.api.TipoRutaCrudService;

import lombok.val;

@Service
public class TipoRutaCrudServiceImpl extends CrudServiceImpl<TipoRuta, TipoRutaDto, Long>
		implements TipoRutaCrudService {
	@Autowired
	private TipoRutaRepository repository;

	@Override
	protected TipoRutaRepository getRepository() {
		return repository;
	}

	@Override
	protected TipoRutaDto asModel(TipoRuta entity) {
		// @formatter:off
		val result = TipoRutaDto
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
	protected TipoRuta asEntity(TipoRutaDto model, TipoRuta entity) {

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected TipoRuta newEntity() {
		return new TipoRuta();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<TipoRutaDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}