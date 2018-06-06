package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.UnidadMedidaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.UnidadMedidaDto;

import lombok.val;

@Service
public class UnidadMedidaLocalServiceImpl extends LocalQueryServiceImpl<UnidadMedidaDto, Long> implements UnidadMedidaLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.unidadMedida;
	}

	@Override
	protected Class<UnidadMedidaDto> getResponseType() {
		return UnidadMedidaDto.class;
	}

	@Override
	protected Class<UnidadMedidaDto[]> getArrayReponseType() {
		return UnidadMedidaDto[].class;
	}

	@Override
	public UnidadMedidaDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}