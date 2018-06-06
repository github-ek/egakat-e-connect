package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.SubestadoInventarioLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.SubestadoInventarioDto;

@Service
public class SubestadoInventarioLocalServiceImpl extends LocalQueryServiceImpl<SubestadoInventarioDto, String> implements SubestadoInventarioLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.subestadoInventario;
	}

	@Override
	protected Class<SubestadoInventarioDto> getResponseType() {
		return SubestadoInventarioDto.class;
	}

	@Override
	protected Class<SubestadoInventarioDto[]> getArrayReponseType() {
		return SubestadoInventarioDto[].class;
	}
}