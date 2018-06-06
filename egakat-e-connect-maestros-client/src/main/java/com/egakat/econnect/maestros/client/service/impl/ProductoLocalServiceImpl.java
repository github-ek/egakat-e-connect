package com.egakat.econnect.maestros.client.service.impl;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.web.client.service.impl.LocalQueryServiceImpl;
import com.egakat.econnect.maestros.client.components.MaestrosRestProperties;
import com.egakat.econnect.maestros.client.service.api.ProductoLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.ProductoAtributoDto;
import com.egakat.econnect.maestros.dto.ProductoCodigoDto;
import com.egakat.econnect.maestros.dto.ProductoDto;
import com.egakat.econnect.maestros.dto.ProductoMedidaDto;

import lombok.val;

@Service
public class ProductoLocalServiceImpl extends LocalQueryServiceImpl<ProductoDto, Long> implements ProductoLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.producto;
	}

	@Override
	protected Class<ProductoDto> getResponseType() {
		return ProductoDto.class;
	}

	@Override
	protected Class<ProductoDto[]> getArrayReponseType() {
		return ProductoDto[].class;
	}

	@Override
	public List<ProductoCodigoDto> getCodigosByProductoId(long producto) {
		val query = RestConstants.codigosByProducto;

		val response = getRestClient().getAllQuery(getResourcePath(), query, ProductoCodigoDto[].class, producto);
		val result = asList(response.getBody());
		return result;
	}

	@Override
	public List<ProductoAtributoDto> getAtributosByProductoId(long producto) {
		val query = RestConstants.atributosByProducto;

		val response = getRestClient().getAllQuery(getResourcePath(), query, ProductoAtributoDto[].class, producto);
		val result = asList(response.getBody());
		return result;
	}

	@Override
	public List<ProductoAtributoDto> getAtributosByProductoIdAndBodegaId(long producto, long bodega) {
		val query = RestConstants.atributosByProducto + "?bodega={bodega}";

		val response = getRestClient().getAllQuery(getResourcePath(), query, ProductoAtributoDto[].class, producto,
				bodega);
		val result = asList(response.getBody());
		return result;
	}

	@Override
	public List<ProductoMedidaDto> getMedidasByProductoId(long producto) {
		val query = RestConstants.medidasByProducto;

		val response = getRestClient().getAllQuery(getResourcePath(), query, ProductoMedidaDto[].class, producto);
		val result = asList(response.getBody());
		return result;
	}

	@Override
	public List<ProductoMedidaDto> getMedidasByProductoIdAndBodegaId(long producto, long bodega) {
		val query = RestConstants.medidasByProducto + "?bodega={bodega}";

		val response = getRestClient().getAllQuery(getResourcePath(), query, ProductoMedidaDto[].class, producto,
				bodega);
		val result = asList(response.getBody());
		return result;
	}
}