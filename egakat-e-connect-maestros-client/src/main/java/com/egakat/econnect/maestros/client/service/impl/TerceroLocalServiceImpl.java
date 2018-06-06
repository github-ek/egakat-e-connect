package com.egakat.econnect.maestros.client.service.impl;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.TerceroLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.PuntoDto;
import com.egakat.econnect.maestros.dto.TerceroDto;

import lombok.val;

@Service
public class TerceroLocalServiceImpl extends LocalQueryServiceImpl<TerceroDto, Long> implements TerceroLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.tercero;
	}

	@Override
	protected Class<TerceroDto> getResponseType() {
		return TerceroDto.class;
	}

	@Override
	protected Class<TerceroDto[]> getArrayReponseType() {
		return TerceroDto[].class;
	}

	@Override
	public PuntoDto getPuntoByTerceroIdAndPuntoCodigo(long tercero, String codigo) {
		val query = RestConstants.puntosByTercero + "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, PuntoDto.class, tercero, codigo);
		val result = response.getBody();
		return result;
	}

	@Override
	public List<PuntoDto> getPuntosByTerceroIdAndCiudadId(long tercero, long ciudad) {
		val query = RestConstants.puntosByTercero + "?ciudad={ciudad}";

		val response = getRestClient().getAllQuery(getResourcePath(), query, PuntoDto[].class, tercero, ciudad);
		val result = asList(response.getBody());
		return result;
	}
}