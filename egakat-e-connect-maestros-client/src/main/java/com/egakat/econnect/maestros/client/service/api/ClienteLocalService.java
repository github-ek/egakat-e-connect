package com.egakat.econnect.maestros.client.service.api;

import java.util.List;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.ClienteDto;
import com.egakat.econnect.maestros.dto.DireccionDto;
import com.egakat.econnect.maestros.dto.ProductoDto;
import com.egakat.econnect.maestros.dto.ServicioDto;
import com.egakat.econnect.maestros.dto.TerceroDto;

public interface ClienteLocalService extends LocalQueryService<ClienteDto, Long> {

	ClienteDto getByCodigo(String codigo);

	ClienteDto getByNumeroIdentificacion(String numeroIdentificacion);
	
	ClienteDto getByCodigoWms(String codigo);


	List<ServicioDto> getServiciosByClienteId(long cliente);

	
	ProductoDto getProductoByClienteIdAndProductoCodigo(long cliente, String codigo);

	List<ProductoDto> getProductosByClienteId(long cliente);

	
	TerceroDto getTerceroByClienteIdAndNumeroIdentificacion(long cliente, String numeroIdentificacion);

	List<TerceroDto> getTercerosByClienteId(long cliente);

	
	List<DireccionDto> getDireccionesByClienteIdAndCiudadId(long cliente, long ciudad);

	DireccionDto getDireccionByClienteIdAndCiudadIdAndDireccion(long cliente, long ciudad, String direccion);
}
