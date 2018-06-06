package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.TipoRemesaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.TipoRemesaDto;

import lombok.val;

@Service
public class TipoRemesaLocalServiceImpl extends LocalQueryServiceImpl<TipoRemesaDto, Long> implements TipoRemesaLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.tipoRemesa;
	}

	@Override
	protected Class<TipoRemesaDto> getResponseType() {
		return TipoRemesaDto.class;
	}

	@Override
	protected Class<TipoRemesaDto[]> getArrayReponseType() {
		return TipoRemesaDto[].class;
	}

	@Override
	public TipoRemesaDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}