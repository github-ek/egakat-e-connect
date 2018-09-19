package com.egakat.econnect.maestros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Direccion;
import com.egakat.econnect.maestros.dto.DireccionDto;
import com.egakat.econnect.maestros.repository.CiudadRepository;
import com.egakat.econnect.maestros.repository.ClienteRepository;
import com.egakat.econnect.maestros.repository.DireccionRepository;
import com.egakat.econnect.maestros.service.api.DireccionCrudService;

import lombok.val;

@Service
public class DireccionCrudServiceImpl extends CrudServiceImpl<Direccion, DireccionDto, Long>
		implements DireccionCrudService {

	@Autowired
	private DireccionRepository repository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CiudadRepository ciudadRepository;

	@Override
	protected DireccionRepository getRepository() {
		return repository;
	}

	@Override
	protected DireccionDto asModel(Direccion entity) {
		// @formatter:off
		val result = DireccionDto
				.builder()
				.id(entity.getId())
				.estado(entity.getEstado())
				.idCliente(entity.getCliente().getId())
				.terceroCodigoAlterno(entity.getTerceroCodigoAlterno())
				.terceroNombre(entity.getTerceroNombre())
				.tipoGeoCodificacion(entity.getTipoGeoCodificacion())
				.idCiudad(entity.getCiudad().getId())
				.direccion(entity.getDireccion())
				.direccionEstandarizada(entity.getDireccionEstandarizada())
				.cx(entity.getCx())
				.cy(entity.getCy())
				.zona(entity.getZona())
				.localidad(entity.getLocalidad())
				.barrio(entity.getBarrio())
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
	protected Direccion mergeEntity(DireccionDto model, Direccion entity) {
		val cliente = clienteRepository.getOne(model.getIdCliente());
		val ciudad = ciudadRepository.getOne(model.getIdCiudad());

		entity.setEstado(model.getEstado());
		entity.setCliente(cliente);
		entity.setTerceroCodigoAlterno(model.getTerceroCodigoAlterno());
		entity.setTerceroNombre(model.getTerceroNombre());
		entity.setTipoGeoCodificacion(model.getTipoGeoCodificacion());
		entity.setCiudad(ciudad);
		entity.setDireccion(model.getDireccion());
		entity.setDireccionEstandarizada(model.getDireccionEstandarizada());
		entity.setCx(model.getCx());
		entity.setCy(model.getCy());
		entity.setZona(model.getZona());
		entity.setLocalidad(model.getLocalidad());
		entity.setBarrio(model.getBarrio());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Direccion newEntity() {
		return new Direccion();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<DireccionDto> findAllByClienteIdAndCiudadId(long cliente, long ciudad) {
		val entities = getRepository().findAllByClienteIdAndCiudadId(cliente, ciudad);
		val result = asModels(entities);
		return result;
	}

	@Override
	public Optional<DireccionDto> findOneByClienteIdAndCiudadIdAndDireccion(long cliente, long ciudad,
			String direccion) {
		val entity = getRepository().findOneByClienteIdAndCiudadIdAndDireccion(cliente, ciudad, direccion);
		if (entity == null) {
			return Optional.empty();
		}
		val result = asModel(entity);
		return Optional.of(result);
	}
}
