package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.PuntoLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.PuntoDto;

@Service
public class PuntoLocalServiceImpl extends LocalQueryServiceImpl<PuntoDto, Long> implements PuntoLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.punto;
	}

	@Override
	protected Class<PuntoDto> getResponseType() {
		return PuntoDto.class;
	}

	@Override
	protected Class<PuntoDto[]> getArrayReponseType() {
		return PuntoDto[].class;
	}
}