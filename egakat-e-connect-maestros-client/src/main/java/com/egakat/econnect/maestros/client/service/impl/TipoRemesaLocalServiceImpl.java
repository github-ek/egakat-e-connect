package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.TipoRemesaLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.TipoRemesaDto;

@Service
public class TipoRemesaLocalServiceImpl extends AbstractLocalQueryServiceImpl<TipoRemesaDto, Long>
		implements TipoRemesaLocalService {

	@Override
	protected String getResourceName() {
		return RestConstants.tipoRemesa;
	}

	@Override
	protected Class<TipoRemesaDto> getResponseType() {
		return TipoRemesaDto.class;
	}

	@Override
	protected Class<TipoRemesaDto[]> getArrayReponseType() {
		return TipoRemesaDto[].class;
	}

}