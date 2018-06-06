package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.BodegaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.BodegaDto;

import lombok.val;

@Service
public class BodegaLocalServiceImpl extends LocalQueryServiceImpl<BodegaDto, Long> implements BodegaLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.bodega;
	}

	@Override
	protected Class<BodegaDto> getResponseType() {
		return BodegaDto.class;
	}

	@Override
	protected Class<BodegaDto[]> getArrayReponseType() {
		return BodegaDto[].class;
	}

	@Override
	public BodegaDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}