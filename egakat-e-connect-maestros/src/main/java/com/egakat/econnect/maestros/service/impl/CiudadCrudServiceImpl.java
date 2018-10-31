
package com.egakat.econnect.maestros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Ciudad;
import com.egakat.econnect.maestros.dto.CiudadDto;
import com.egakat.econnect.maestros.repository.CiudadRepository;
import com.egakat.econnect.maestros.repository.DepartamentoRepository;
import com.egakat.econnect.maestros.service.api.CiudadCrudService;

import lombok.val;

@Service
public class CiudadCrudServiceImpl extends CrudServiceImpl<Ciudad, CiudadDto, Long> implements CiudadCrudService {

	@Autowired
	private CiudadRepository repository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	protected CiudadRepository getRepository() {
		return repository;
	}

	@Override
	protected CiudadDto asModel(Ciudad entity) {
		val result = newModel();
		mapModel(entity, result);

		result.setIdDepartamento(entity.getDepartamento().getId());
		result.setCodigo(entity.getCodigo());
		result.setCodigoCentroPoblado(entity.getCodigoCentroPoblado());
		result.setNombre(entity.getNombre());
		result.setNombreAlterno(entity.getNombreAlterno());
		result.setCx(entity.getCx());
		result.setCy(entity.getCy());
		result.setOrdinal(entity.getOrdinal());
		result.setActivo(entity.isActivo());

		return result;
	}

	@Override
	protected CiudadDto newModel() {
		return new CiudadDto();
	}

	@Override
	protected Ciudad mergeEntity(CiudadDto model, Ciudad entity) {
		val departamento = departamentoRepository.getOne(model.getIdDepartamento());

		entity.setDepartamento(departamento);
		entity.setCodigo(model.getCodigo());
		entity.setCodigoCentroPoblado(model.getCodigoCentroPoblado());
		entity.setNombre(model.getNombre());
		entity.setNombreAlterno(model.getNombreAlterno());
		entity.setCx(model.getCx());
		entity.setCy(model.getCy());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Ciudad newEntity() {
		return new Ciudad();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<CiudadDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}

	@Override
	public Optional<CiudadDto> findOneByNombreAlterno(String nombreAlterno) {
		val entity = getRepository().findOneByNombreAlterno(nombreAlterno);
		if (entity == null) {
			return Optional.empty();
		}
		val result = asModel(entity);
		return Optional.of(result);
	}

	@Override
	public List<CiudadDto> findAllByDepartamentoId(long departamento) {
		val entities = getRepository().findAllByDepartamentoId(departamento);
		val result = asModels(entities);
		return result;
	}
}
