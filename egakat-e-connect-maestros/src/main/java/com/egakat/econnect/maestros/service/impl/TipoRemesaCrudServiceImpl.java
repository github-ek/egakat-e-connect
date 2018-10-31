package com.egakat.econnect.maestros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.TipoRemesa;
import com.egakat.econnect.maestros.dto.TipoRemesaDto;
import com.egakat.econnect.maestros.repository.TipoRemesaRepository;
import com.egakat.econnect.maestros.repository.UnidadNegocioRepository;
import com.egakat.econnect.maestros.service.api.TipoRemesaCrudService;

import lombok.val;

@Service
public class TipoRemesaCrudServiceImpl extends CrudServiceImpl<TipoRemesa, TipoRemesaDto, Long>
		implements TipoRemesaCrudService {

	@Autowired
	private TipoRemesaRepository repository;

	@Autowired
	private UnidadNegocioRepository unidadNegocioRepository;

	@Override
	protected TipoRemesaRepository getRepository() {
		return repository;
	}

	@Override
	protected TipoRemesaDto asModel(TipoRemesa entity) {
		val result = newModel();
		mapModel(entity, result);

		result.setIdUnidadNegocio(entity.getUnidadNegocio().getId());
		result.setCodigo(entity.getCodigo());
		result.setNombre(entity.getNombre());
		result.setDescripcion(entity.getDescripcion());
		result.setOrdinal(entity.getOrdinal());
		result.setActivo(entity.isActivo());

		return result;
	}

	@Override
	protected TipoRemesaDto newModel() {
		return new TipoRemesaDto();
	}

	@Override
	protected TipoRemesa mergeEntity(TipoRemesaDto model, TipoRemesa entity) {
		val unidadNegocio = unidadNegocioRepository.getOne(model.getIdUnidadNegocio());

		entity.setUnidadNegocio(unidadNegocio);
		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected TipoRemesa newEntity() {
		return new TipoRemesa();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<TipoRemesaDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}

	@Override
	public List<TipoRemesaDto> findAllByUnidadNegocioId(long unidadNegocio) {
		val entities = getRepository().findAllByUnidadNegocioId(unidadNegocio);
		val result = asModels(entities);
		return result;
	}
}