package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.EmpresaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.EmpresaDto;

@Service
public class EmpresaLocalServiceImpl extends AbstractLocalQueryServiceImpl<EmpresaDto, Long> implements EmpresaLocalService {

	@Override
	protected String getResourceName() {
		return RestConstants.empresa;
	}

	@Override
	protected Class<EmpresaDto> getResponseType() {
		return EmpresaDto.class;
	}

	@Override
	protected Class<EmpresaDto[]> getArrayReponseType() {
		return EmpresaDto[].class;
	}

}