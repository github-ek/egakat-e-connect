package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.UnidadMedidaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.UnidadMedidaDto;

@Service
public class UnidadMedidaLocalServiceImpl extends AbstractLocalQueryServiceImpl<UnidadMedidaDto, Long> implements UnidadMedidaLocalService {

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
}