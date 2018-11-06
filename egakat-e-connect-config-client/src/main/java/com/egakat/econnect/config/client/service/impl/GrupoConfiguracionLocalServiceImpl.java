package com.egakat.econnect.config.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.config.client.properties.ConnectConfigRestProperties;
import com.egakat.econnect.config.client.service.api.GrupoConfiguracionLocalService;
import com.egakat.econnect.config.constants.RestConstants;
import com.egakat.econnect.config.dto.ConfiguracionDto;
import com.egakat.econnect.config.dto.GrupoConfiguracionDto;

import lombok.val;

@Service
public class GrupoConfiguracionLocalServiceImpl extends LocalQueryServiceImpl<GrupoConfiguracionDto, Long>
		implements GrupoConfiguracionLocalService {

	@Autowired
	private ConnectConfigRestProperties properties;

	protected ConnectConfigRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.grupoConfiguracion;
	}

	@Override
	protected Class<GrupoConfiguracionDto> getResponseType() {
		return GrupoConfiguracionDto.class;
	}

	@Override
	protected Class<GrupoConfiguracionDto[]> getArrayReponseType() {
		return GrupoConfiguracionDto[].class;
	}

	@Override
	public GrupoConfiguracionDto getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
	
	@Override
	public ConfiguracionDto getConfiguracionByGrupoConfiguracionIdAndConfiguracionCodigo(long grupoConfiguracion, String codigo) {
		val query = RestConstants.configuracionesByGrupoConfiguracion + "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, ConfiguracionDto.class, grupoConfiguracion, codigo);
		val result = response.getBody();
		return result;
	}
}
