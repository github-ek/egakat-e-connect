package com.egakat.econnect.maestros.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Empresa;
import com.egakat.econnect.maestros.dto.EmpresaDto;
import com.egakat.econnect.maestros.repository.EmpresaRepository;
import com.egakat.econnect.maestros.service.api.EmpresaCrudService;

import lombok.val;

@Service
public class EmpresaCrudServiceImpl extends CrudServiceImpl<Empresa, EmpresaDto, Long> implements EmpresaCrudService {
	@Autowired
	private EmpresaRepository repository;

	@Override
	protected EmpresaRepository getRepository() {
		return repository;
	}

	@Override
	protected EmpresaDto asModel(Empresa entity) {
		val result = newModel();
		mapModel(entity, result);

		result.setCodigo(entity.getCodigo());
		result.setNombre(entity.getNombre());
		result.setTipoIdentificacion(entity.getTipoIdentificacion());
		result.setNumeroIdentificacion(entity.getNumeroIdentificacion());
		result.setDigitoVerificacion(entity.getDigitoVerificacion());
		result.setOrdinal(entity.getOrdinal());
		result.setActivo(entity.isActivo());

		return result;
	}

	@Override
	protected EmpresaDto newModel() {
		return new EmpresaDto();
	}

	@Override
	protected Empresa mergeEntity(EmpresaDto model, Empresa entity) {

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setTipoIdentificacion(model.getTipoIdentificacion());
		entity.setNumeroIdentificacion(model.getNumeroIdentificacion());
		entity.setDigitoVerificacion(model.getDigitoVerificacion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Empresa newEntity() {
		return new Empresa();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<EmpresaDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}

}