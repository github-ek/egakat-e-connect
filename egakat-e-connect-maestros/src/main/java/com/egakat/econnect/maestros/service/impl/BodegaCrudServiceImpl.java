package com.egakat.econnect.maestros.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Bodega;
import com.egakat.econnect.maestros.dto.BodegaDto;
import com.egakat.econnect.maestros.repository.BodegaRepository;
import com.egakat.econnect.maestros.repository.CiudadRepository;
import com.egakat.econnect.maestros.repository.DireccionRepository;
import com.egakat.econnect.maestros.service.api.BodegaCrudService;

import lombok.val;

@Service
public class BodegaCrudServiceImpl extends CrudServiceImpl<Bodega, BodegaDto, Long> implements BodegaCrudService {

	@Autowired
	private BodegaRepository repository;

	@Autowired
	private CiudadRepository ciudadRepository;

	@Autowired
	private DireccionRepository direccionRepository;

	@Override
	protected BodegaRepository getRepository() {
		return repository;
	}

	@Override
	protected BodegaDto asModel(Bodega entity) {
		Long idDireccion = (entity.getObjetoDireccion() != null) ? entity.getObjetoDireccion().getId() : null;

		// @formatter:off
		val result = BodegaDto
				.builder()
				.id(entity.getId())
				.codigo(entity.getCodigo())
				.nombre(entity.getNombre())
				.idCiudad(entity.getCiudad().getId())
				.direccion(entity.getDireccion())
				.idDireccion(idDireccion)
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
	protected Bodega asEntity(BodegaDto model, Bodega entity) {
		val ciudad = ciudadRepository.getOne(model.getIdCiudad());
		val direccion = direccionRepository.getOne(model.getIdDireccion());

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setCiudad(ciudad);
		entity.setDireccion(model.getDireccion());
		entity.setObjetoDireccion(direccion);
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Bodega newEntity() {
		return new Bodega();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<BodegaDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}