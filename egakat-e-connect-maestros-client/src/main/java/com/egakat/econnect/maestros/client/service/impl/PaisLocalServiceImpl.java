package com.egakat.econnect.maestros.client.service.impl;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.PaisLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.DepartamentoDto;
import com.egakat.econnect.maestros.dto.PaisDto;

import lombok.val;

@Service
public class PaisLocalServiceImpl extends LocalQueryServiceImpl<PaisDto, Long> implements PaisLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

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
	public PaisDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
	
	@Override
	public List<DepartamentoDto> getDepartamentosByPaisId(long pais) {
		val query = RestConstants.departamentosByPais;

		val response = getRestClient().getAllQuery(getResourcePath(), query, DepartamentoDto[].class, pais);
		val result = asList(response.getBody());
		return result;
	}
}