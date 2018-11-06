package com.egakat.econnect.maestros.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.CiudadDto;

public interface CiudadLocalService extends LocalQueryService<CiudadDto, Long> {

	CiudadDto getByCodigo(String codigo);
	
	CiudadDto getByNombreAlterno(String nombreAlterno);
}
