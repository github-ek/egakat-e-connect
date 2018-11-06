package com.egakat.econnect.maestros.client.service.impl;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.PaisLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.DepartamentoDto;
import com.egakat.econnect.maestros.dto.PaisDto;

import lombok.val;

@Service
public class PaisLocalServiceImpl extends AbstractLocalQueryServiceImpl<PaisDto, Long> implements PaisLocalService {
	@Override
	protected String getResourceName() {
		return RestConstants.pais;
	}

	@Override
	protected Class<PaisDto> getResponseType() {
		return PaisDto.class;
	}

	@Override
	protected Class<PaisDto[]> getArrayReponseType() {
		return PaisDto[].class;
	}

	@Override
	public List<DepartamentoDto> getDepartamentosByPaisId(long pais) {
		val query = RestConstants.departamentosByPais;

		val response = getRestClient().getAllQuery(getResourcePath(), query, DepartamentoDto[].class, pais);
		val result = asList(response.getBody());
		return result;
	}
}