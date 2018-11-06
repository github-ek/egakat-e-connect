package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.CiudadLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.CiudadDto;

import lombok.val;

@Service
public class CiudadLocalServiceImpl extends AbstractLocalQueryServiceImpl<CiudadDto, Long>
		implements CiudadLocalService {

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
	public CiudadDto getByNombreAlterno(String nombreAlterno) {
		val query = "?nombreAlterno={nombreAlterno}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), nombreAlterno);
		val result = response.getBody();
		return result;
	}
}