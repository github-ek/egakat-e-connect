package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.CanalLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.CanalDto;

@Service
public class CanalLocalServiceImpl extends AbstractLocalQueryServiceImpl<CanalDto, Long> implements CanalLocalService {

	protected String getResourceName() {
		return RestConstants.canal;
	}

	@Override
	protected Class<CanalDto> getResponseType() {
		return CanalDto.class;
	}

	@Override
	protected Class<CanalDto[]> getArrayReponseType() {
		return CanalDto[].class;
	}
}