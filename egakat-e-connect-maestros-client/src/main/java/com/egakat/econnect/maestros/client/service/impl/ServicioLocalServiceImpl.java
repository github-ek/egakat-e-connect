package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.ServicioLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.ServicioDto;

@Service
public class ServicioLocalServiceImpl extends AbstractLocalQueryServiceImpl<ServicioDto, Long>
		implements ServicioLocalService {

	@Override
	protected String getResourceName() {
		return RestConstants.servicio;
	}

	@Override
	protected Class<ServicioDto> getResponseType() {
		return ServicioDto.class;
	}

	@Override
	protected Class<ServicioDto[]> getArrayReponseType() {
		return ServicioDto[].class;
	}
}