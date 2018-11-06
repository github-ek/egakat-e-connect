package com.egakat.econnect.maestros.client.service.impl;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.UnidadNegocioLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.LineaNegocioDto;
import com.egakat.econnect.maestros.dto.TipoRemesaDto;
import com.egakat.econnect.maestros.dto.UnidadNegocioDto;

import lombok.val;

@Service
public class UnidadNegocioLocalServiceImpl extends AbstractLocalQueryServiceImpl<UnidadNegocioDto, Long>
		implements UnidadNegocioLocalService {

	@Override
	protected String getResourceName() {
		return RestConstants.unidadNegocio;
	}

	@Override
	protected Class<UnidadNegocioDto> getResponseType() {
		return UnidadNegocioDto.class;
	}

	@Override
	protected Class<UnidadNegocioDto[]> getArrayReponseType() {
		return UnidadNegocioDto[].class;
	}

	@Override
	public List<LineaNegocioDto> getLineasNegocioByUnidadNegocioId(long unidadNegocio) {
		val query = RestConstants.lineasNegocioByUnidadNegocio;

		val response = getRestClient().getAllQuery(getResourcePath(), query, LineaNegocioDto[].class, unidadNegocio);
		val result = asList(response.getBody());
		return result;
	}

	@Override
	public List<TipoRemesaDto> getTiposRemesaByUnidadNegocioId(long unidadNegocio) {
		val query = RestConstants.tiposRemesaByUnidadNegocio;

		val response = getRestClient().getAllQuery(getResourcePath(), query, TipoRemesaDto[].class, unidadNegocio);
		val result = asList(response.getBody());
		return result;
	}
}