package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.EmpresaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.EmpresaDto;

import lombok.val;

@Service
public class EmpresaLocalServiceImpl extends LocalQueryServiceImpl<EmpresaDto, Long> implements EmpresaLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.empresa;
	}

	@Override
	protected Class<EmpresaDto> getResponseType() {
		return EmpresaDto.class;
	}

	@Override
	protected Class<EmpresaDto[]> getArrayReponseType() {
		return EmpresaDto[].class;
	}

	@Override
	public EmpresaDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}