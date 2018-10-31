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

		val result = newModel();
		mapModel(entity, result);

		result.setCodigo(entity.getCodigo());
		result.setNombre(entity.getNombre());
		result.setIdCiudad(entity.getCiudad().getId());
		result.setDireccion(entity.getDireccion());
		result.setIdDireccion(idDireccion);
		result.setOrdinal(entity.getOrdinal());
		result.setActivo(entity.isActivo());

		return result;
	}

	@Override
	protected BodegaDto newModel() {
		return new BodegaDto();
	}

	@Override
	protected Bodega mergeEntity(BodegaDto model, Bodega entity) {
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