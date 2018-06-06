package com.egakat.econnect.maestros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Tercero;
import com.egakat.econnect.maestros.dto.TerceroDto;
import com.egakat.econnect.maestros.repository.ClienteRepository;
import com.egakat.econnect.maestros.repository.TerceroRepository;
import com.egakat.econnect.maestros.service.api.TerceroCrudService;

import lombok.val;

@Service
public class TerceroCrudServiceImpl extends CrudServiceImpl<Tercero, TerceroDto, Long> implements TerceroCrudService {

	@Autowired
	private TerceroRepository repository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	protected TerceroRepository getRepository() {
		return repository;
	}

	@Override
	protected TerceroDto asModel(Tercero entity) {
		// @formatter:off
		val result = TerceroDto
				.builder()
				.id(entity.getId())
				.idCliente(entity.getCliente().getId())
				.tipoIdentificacion(entity.getTipoIdentificacion())
				.numeroIdentificacion(entity.getNumeroIdentificacion())
				.nombre(entity.getNombre())
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
	protected Tercero asEntity(TerceroDto model, Tercero entity) {
		val cliente = clienteRepository.getOne(model.getIdCliente());

		entity.setCliente(cliente);
		entity.setTipoIdentificacion(model.getTipoIdentificacion());
		entity.setNumeroIdentificacion(model.getNumeroIdentificacion());
		entity.setNombre(model.getNombre());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Tercero newEntity() {
		return new Tercero();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<TerceroDto> findOneByClienteIdAndNumeroIdentificacion(long cliente, String numeroIdentificacion) {
		val entity = getRepository().findOneByClienteIdAndNumeroIdentificacion(cliente, numeroIdentificacion);
		if ((entity == null) || ((entity != null) && (!entity.isActivo()))) {
			return Optional.empty();
		}
		val result = asModel(entity);
		return Optional.of(result);
	}

	@Override
	public List<TerceroDto> finaAllByClienteId(long cliente) {
		val entities = getRepository().findAllByClienteId(cliente);
		val result = asModels(entities);
		return result;
	}
}
