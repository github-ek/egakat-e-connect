package com.egakat.econnect.maestros.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.egakat.core.web.client.components.RestClient;
import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.ConnectMaestrosRestClient;
import com.egakat.econnect.maestros.client.properties.ConnectMaestrosRestProperties;

import lombok.val;

public abstract class AbstractLocalQueryServiceImpl<M, ID> extends LocalQueryServiceImpl<M, ID> {

	@Autowired
	private ConnectMaestrosRestProperties properties;
	
	@Autowired
	private ConnectMaestrosRestClient restClient;

	protected ConnectMaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected RestClient getRestClient() {
		return restClient;
	}

	public M getByCodigo(String codigo) {
		val query = "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}
}