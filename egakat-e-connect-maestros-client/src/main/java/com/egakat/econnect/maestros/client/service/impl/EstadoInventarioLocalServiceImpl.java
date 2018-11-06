package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.components.RestClient;
import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.ConnectMaestrosRestClient;
import com.egakat.econnect.maestros.client.properties.ConnectMaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.EstadoInventarioLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.EstadoInventarioDto;

@Service
public class EstadoInventarioLocalServiceImpl extends LocalQueryServiceImpl<EstadoInventarioDto, String>
		implements EstadoInventarioLocalService {

	@Autowired
	private ConnectMaestrosRestProperties properties;

	@Autowired
	private ConnectMaestrosRestClient restClient;

	protected ConnectMaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected RestClient getRestClient() {
		return restClient;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.estadoInventario;
	}

	@Override
	protected Class<EstadoInventarioDto> getResponseType() {
		return EstadoInventarioDto.class;
	}

	@Override
	protected Class<EstadoInventarioDto[]> getArrayReponseType() {
		return EstadoInventarioDto[].class;
	}
}