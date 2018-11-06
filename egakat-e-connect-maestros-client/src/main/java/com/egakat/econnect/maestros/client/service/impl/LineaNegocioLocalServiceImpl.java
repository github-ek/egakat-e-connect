package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.LineaNegocioLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.LineaNegocioDto;

@Service
public class LineaNegocioLocalServiceImpl extends AbstractLocalQueryServiceImpl<LineaNegocioDto, Long>
		implements LineaNegocioLocalService {

	@Override
	protected String getResourceName() {
		return RestConstants.lineaNegocio;
	}

	@Override
	protected Class<LineaNegocioDto> getResponseType() {
		return LineaNegocioDto.class;
	}

	@Override
	protected Class<LineaNegocioDto[]> getArrayReponseType() {
		return LineaNegocioDto[].class;
	}
}