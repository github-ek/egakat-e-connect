package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.ServicioLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.ServicioDto;

import lombok.val;

@Service
public class ServicioLocalServiceImpl extends LocalQueryServiceImpl<ServicioDto, Long> implements ServicioLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.servicio;
	}

	@Override
	protected Class<ServicioDto> getResponseType() {
		return ServicioDto.class;
	}

	@Override
	protected Class<ServicioDto[]> getArrayReponseType() {
		return ServicioDto[].class;
	}

	@Override
	public ServicioDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}