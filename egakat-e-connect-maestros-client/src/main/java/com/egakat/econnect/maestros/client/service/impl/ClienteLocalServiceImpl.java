package com.egakat.econnect.maestros.client.service.impl;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.egakat.econnect.maestros.client.service.api.ClienteLocalService;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.ClienteDto;
import com.egakat.econnect.maestros.dto.DireccionDto;
import com.egakat.econnect.maestros.dto.ProductoDto;
import com.egakat.econnect.maestros.dto.ServicioDto;
import com.egakat.econnect.maestros.dto.TerceroDto;

import lombok.val;

@Service
public class ClienteLocalServiceImpl extends AbstractLocalQueryServiceImpl<ClienteDto, Long> implements ClienteLocalService {

	@Override
	protected String getResourceName() {
		return RestConstants.cliente;
	}

	@Override
	protected Class<ClienteDto> getResponseType() {
		return ClienteDto.class;
	}

	@Override
	protected Class<ClienteDto[]> getArrayReponseType() {
		return ClienteDto[].class;
	}

	@Override
	public ClienteDto getByNumeroIdentificacion(String numeroIdentificacion) {
		val query = "?numeroIdentificacion={numeroIdentificacion}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), numeroIdentificacion);
		val result = response.getBody();
		return result;
	}

	@Override
	public ClienteDto getByCodigoWms(String codigo) {
		val query = "?codigoAlternoWms={codigoAlternoWms}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, getResponseType(), codigo);
		val result = response.getBody();
		return result;
	}

	@Override
	public List<ServicioDto> getServiciosByClienteId(long cliente) {
		val query = RestConstants.serviciosByCliente;

		val response = getRestClient().getAllQuery(getResourcePath(), query, ServicioDto[].class, cliente);
		val result = asList(response.getBody());
		return result;
	}

	@Override
	public List<ProductoDto> getProductosByClienteId(long cliente) {
		val query = RestConstants.productosByCliente;

		val response = getRestClient().getAllQuery(getResourcePath(), query, ProductoDto[].class, cliente);
		val result = asList(response.getBody());
		return result;
	}

	@Override
	public ProductoDto getProductoByClienteIdAndProductoCodigo(long cliente, String codigo) {
		val query = RestConstants.productosByCliente + "?codigo={codigo}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, ProductoDto.class, cliente, codigo);
		val result = response.getBody();
		return result;
	}

	@Override
	public List<TerceroDto> getTercerosByClienteId(long cliente) {
		val query = RestConstants.tercerosByCliente;

		val response = getRestClient().getAllQuery(getResourcePath(), query, TerceroDto[].class, cliente);
		val result = asList(response.getBody());
		return result;
	}

	@Override
	public TerceroDto getTerceroByClienteIdAndNumeroIdentificacion(long cliente, String numeroIdentificacion) {
		val query = RestConstants.tercerosByCliente + "?numeroIdentificacion={numeroIdentificacion}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, TerceroDto.class, cliente,
				numeroIdentificacion);
		val result = response.getBody();
		return result;
	}

	@Override
	public List<DireccionDto> getDireccionesByClienteIdAndCiudadId(long cliente, long ciudad) {
		val query = RestConstants.direccionesByCliente + "?ciudad={ciudad}";

		val response = getRestClient().getAllQuery(getResourcePath(), query, DireccionDto[].class, cliente, ciudad);
		val result = asList(response.getBody());
		return result;
	}

	@Override
	public DireccionDto getDireccionByClienteIdAndCiudadIdAndDireccion(long cliente, long ciudad, String direccion) {
		val query = RestConstants.direccionesByCliente + "?ciudad={ciudad}&direccion={direccion}";

		val response = getRestClient().getOneQuery(getResourcePath(), query, DireccionDto.class, cliente, ciudad,
				direccion);
		val result = response.getBody();
		return result;
	}
}