package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.BodegaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.BodegaDto;

@Service
public class BodegaLocalServiceImpl extends AbstractLocalQueryServiceImpl<BodegaDto, Long>
		implements BodegaLocalService {

	@Override
	protected String getResourceName() {
		return RestConstants.bodega;
	}

	@Override
	protected Class<BodegaDto> getResponseType() {
		return BodegaDto.class;
	}

	@Override
	protected Class<BodegaDto[]> getArrayReponseType() {
		return BodegaDto[].class;
	}
}