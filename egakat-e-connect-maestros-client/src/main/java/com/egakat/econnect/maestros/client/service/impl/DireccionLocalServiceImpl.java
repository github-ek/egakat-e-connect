package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.DireccionLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.DireccionDto;

@Service
public class DireccionLocalServiceImpl extends LocalQueryServiceImpl<DireccionDto, Long> implements DireccionLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.direccion;
	}

	@Override
	protected Class<DireccionDto> getResponseType() {
		return DireccionDto.class;
	}

	@Override
	protected Class<DireccionDto[]> getArrayReponseType() {
		return DireccionDto[].class;
	}
}