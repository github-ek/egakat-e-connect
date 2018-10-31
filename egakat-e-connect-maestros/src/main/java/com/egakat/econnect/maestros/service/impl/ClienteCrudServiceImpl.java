package com.egakat.econnect.maestros.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Cliente;
import com.egakat.econnect.maestros.dto.ClienteDto;
import com.egakat.econnect.maestros.dto.ServicioDto;
import com.egakat.econnect.maestros.repository.ClienteRepository;
import com.egakat.econnect.maestros.repository.EmpresaRepository;
import com.egakat.econnect.maestros.service.api.ClienteCrudService;
import com.egakat.econnect.maestros.service.api.ServicioCrudService;

import lombok.val;

@Service
public class ClienteCrudServiceImpl extends CrudServiceImpl<Cliente, ClienteDto, Long> implements ClienteCrudService {

	@Autowired
	private ServicioCrudService servicioCrudService;

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected ClienteRepository getRepository() {
		return repository;
	}

	@Override
	protected ClienteDto asModel(Cliente entity) {
		val result = newModel();
		mapModel(entity, result);

		result.setCodigo(entity.getCodigo());
		result.setNombre(entity.getNombre());
		result.setTipoIdentificacion(entity.getTipoIdentificacion());
		result.setNumeroIdentificacion(entity.getNumeroIdentificacion());
		result.setDigitoVerificacion(entity.getDigitoVerificacion());
		result.setIdEmpresa(entity.getEmpresa().getId());
		result.setCodigoAlternoWms(entity.getCodigoAlternoWms());
		result.setHabilitadoConciliacion(entity.isHabilitadoConciliacion());
		result.setActivo(entity.isActivo());

		return result;
	}

	@Override
	protected ClienteDto newModel() {
		return new ClienteDto();
	}

	@Override
	protected Cliente mergeEntity(ClienteDto model, Cliente entity) {
		val empresa = empresaRepository.getOne(model.getIdEmpresa());

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setTipoIdentificacion(model.getTipoIdentificacion());
		entity.setNumeroIdentificacion(model.getNumeroIdentificacion());
		entity.setDigitoVerificacion(model.getDigitoVerificacion());
		entity.setEmpresa(empresa);
		entity.setCodigoAlternoWms(model.getCodigoAlternoWms());
		entity.setHabilitadoConciliacion(model.isHabilitadoConciliacion());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Cliente newEntity() {
		return new Cliente();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<ClienteDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}

	@Override
	public ClienteDto findOneByNumeroIdentificacion(String numeroIdentificacion) {
		val optional = getRepository().findOneByNumeroIdentificacion(numeroIdentificacion);
		if (!optional.isPresent()) {
			throw new EntityNotFoundException("numeroIdentificacion = " + numeroIdentificacion);
		}
		val result = asModel(optional.get());
		return result;
	}

	@Override
	public ClienteDto findOneByCodigoWms(String codigo) {
		val optional = getRepository().findOneByCodigoAlternoWms(codigo);
		if (!optional.isPresent()) {
			throw new EntityNotFoundException("codigo = " + codigo);
		}
		val result = asModel(optional.get());
		return result;
	}

	@Override
	public List<ServicioDto> findAllServiciosByClienteId(long id) {
		val optional = getRepository().findById(id);
		if (!optional.isPresent()) {
			throw new EntityNotFoundException("id = " + id);
		}

		val entity = optional.get();
		val ids = entity.getServicios().stream().map(a -> a.getIdServicio()).collect(Collectors.toList());
		val result = servicioCrudService.findAllById(ids);
		return result;
	}

}