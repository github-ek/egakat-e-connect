package com.egakat.econnect.conciliaciones.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.conciliaciones.client.components.ConciliacionesRestProperties;
import com.egakat.econnect.conciliaciones.client.service.api.EstadoConciliacionLocalService;
import com.egakat.econnect.conciliaciones.constants.RestConstants;
import com.egakat.econnect.conciliaciones.dto.EstadoConciliacionDto;

import lombok.val;

@Service
public class EstadoConciliacionLocalServiceImpl extends LocalQueryServiceImpl<EstadoConciliacionDto, Long> implements EstadoConciliacionLocalService {

	@Autowired
	private ConciliacionesRestProperties properties;

	protected ConciliacionesRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.estadoConciliacion;
	}

	@Override
	protected Class<EstadoConciliacionDto> getResponseType() {
		return EstadoConciliacionDto.class;
	}

	@Override
	protected Class<EstadoConciliacionDto[]> getArrayReponseType() {
		return EstadoConciliacionDto[].class;
	}

	@Override
	public EstadoConciliacionDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}