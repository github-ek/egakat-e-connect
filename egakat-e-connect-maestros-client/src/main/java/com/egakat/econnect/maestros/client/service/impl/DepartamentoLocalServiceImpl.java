package com.egakat.econnect.maestros.client.service.impl;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.DepartamentoLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.CiudadDto;
import com.egakat.econnect.maestros.dto.DepartamentoDto;

import lombok.val;

@Service
public class DepartamentoLocalServiceImpl extends AbstractLocalQueryServiceImpl<DepartamentoDto, Long> implements DepartamentoLocalService {

	@Override
	protected String getResourceName() {
		return RestConstants.departamento;
	}

	@Override
	protected Class<DepartamentoDto> getResponseType() {
		return DepartamentoDto.class;
	}

	@Override
	protected Class<DepartamentoDto[]> getArrayReponseType() {
		return DepartamentoDto[].class;
	}

	@Override
	public List<CiudadDto> getCiudadesByDepartamentoId(long departamento) {
		val query = RestConstants.ciudadesByDepartamento;

		val response = getRestClient().getAllQuery(getResourcePath(), query, CiudadDto[].class, departamento);
		val result = asList(response.getBody());
		return result;
	}
}