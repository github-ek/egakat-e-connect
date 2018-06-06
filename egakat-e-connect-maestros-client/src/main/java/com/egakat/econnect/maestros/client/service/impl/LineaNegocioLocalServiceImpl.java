package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.LineaNegocioLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.LineaNegocioDto;

import lombok.val;

@Service
public class LineaNegocioLocalServiceImpl extends LocalQueryServiceImpl<LineaNegocioDto, Long> implements LineaNegocioLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.lineaNegocio;
	}

	@Override
	protected Class<LineaNegocioDto> getResponseType() {
		return LineaNegocioDto.class;
	}

	@Override
	protected Class<LineaNegocioDto[]> getArrayReponseType() {
		return LineaNegocioDto[].class;
	}

	@Override
	public LineaNegocioDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}