package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.CanalLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.CanalDto;

import lombok.val;

@Service
public class CanalLocalServiceImpl extends LocalQueryServiceImpl<CanalDto, Long> implements CanalLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.canal;
	}

	@Override
	protected Class<CanalDto> getResponseType() {
		return CanalDto.class;
	}

	@Override
	protected Class<CanalDto[]> getArrayReponseType() {
		return CanalDto[].class;
	}

	@Override
	public CanalDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}