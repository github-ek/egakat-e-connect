package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.TipoRutaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.TipoRutaDto;

import lombok.val;

@Service
public class TipoRutaLocalServiceImpl extends LocalQueryServiceImpl<TipoRutaDto, Long> implements TipoRutaLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.tipoRuta;
	}

	@Override
	protected Class<TipoRutaDto> getResponseType() {
		return TipoRutaDto.class;
	}

	@Override
	protected Class<TipoRutaDto[]> getArrayReponseType() {
		return TipoRutaDto[].class;
	}

	@Override
	public TipoRutaDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}