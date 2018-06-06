package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.CiudadLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.CiudadDto;

import lombok.val;

@Service
public class CiudadLocalServiceImpl extends LocalQueryServiceImpl<CiudadDto, Long> implements CiudadLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.ciudad;
	}

	@Override
	protected Class<CiudadDto> getResponseType() {
		return CiudadDto.class;
	}

	@Override
	protected Class<CiudadDto[]> getArrayReponseType() {
		return CiudadDto[].class;
	}

	@Override
	public CiudadDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}

	@Override
	public CiudadDto getByNombreAlterno(String nombreAlterno) {
		val query = "?nombreAlterno={nombreAlterno}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), nombreAlterno);
		val result = response.getBody();
		return result;
	}
}