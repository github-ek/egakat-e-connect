package com.egakat.econnect.maestros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Punto;
import com.egakat.econnect.maestros.dto.PuntoDto;
import com.egakat.econnect.maestros.repository.CiudadRepository;
import com.egakat.econnect.maestros.repository.DireccionRepository;
import com.egakat.econnect.maestros.repository.PuntoRepository;
import com.egakat.econnect.maestros.repository.TerceroRepository;
import com.egakat.econnect.maestros.service.api.PuntoCrudService;

import lombok.val;

@Service
public class PuntoCrudServiceImpl extends CrudServiceImpl<Punto, PuntoDto, Long> implements PuntoCrudService {

	@Autowired
	private PuntoRepository repository;

	@Autowired
	private TerceroRepository terceroRepository;

	@Autowired
	private CiudadRepository ciudadRepository;

	@Autowired
	private DireccionRepository direccionRepository;

	@Override
	protected PuntoRepository getRepository() {
		return repository;
	}

	@Override
	protected PuntoDto asModel(Punto entity) {
		Long idDireccion = (entity.getObjetoDireccion() != null) ? entity.getObjetoDireccion().getId() : null;
		val result = newModel();
		mapModel(entity, result);

		result.setIdTercero(entity.getTercero().getId());
		result.setCodigo(entity.getCodigo());
		result.setNombre(entity.getNombre());
		result.setIdCiudad(entity.getCiudad().getId());
		result.setDireccion(entity.getDireccion());
		result.setIdDireccion(idDireccion);
		result.setActivo(entity.isActivo());

		return result;
	}
	
	@Override
	protected PuntoDto newModel() {
		return new PuntoDto();
	}

	@Override
	protected Punto mergeEntity(PuntoDto model, Punto entity) {
		val tercero = terceroRepository.getOne(model.getIdTercero());
		val ciudad = ciudadRepository.getOne(model.getIdCiudad());
		val direccion = direccionRepository.getOne(model.getIdDireccion());

		entity.setTercero(tercero);
		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setCiudad(ciudad);
		entity.setDireccion(model.getDireccion());
		entity.setObjetoDireccion(direccion);
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Punto newEntity() {
		return new Punto();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<PuntoDto> findOneByTerceroIdAndCodigo(long tercero, String codigo) {
		val entity = getRepository().findOneByTerceroIdAndCodigo(tercero, codigo);
		if ((entity == null) || ((entity != null) && (!entity.isActivo()))) {
			return Optional.empty();
		}
		val result = asModel(entity);
		return Optional.of(result);
	}

	@Override
	public List<PuntoDto> findAllByTerceroIdAndCiudadId(long tercero, long ciudad) {
		val entities = getRepository().findAllByTerceroIdAndCiudadId(tercero, ciudad);
		val result = asModels(entities);
		return result;
	}
}