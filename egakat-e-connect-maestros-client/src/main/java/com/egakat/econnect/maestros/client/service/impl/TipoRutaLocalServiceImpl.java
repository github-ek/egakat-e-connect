package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.TipoRutaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.TipoRutaDto;

@Service
public class TipoRutaLocalServiceImpl extends AbstractLocalQueryServiceImpl<TipoRutaDto, Long> implements TipoRutaLocalService {

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

}