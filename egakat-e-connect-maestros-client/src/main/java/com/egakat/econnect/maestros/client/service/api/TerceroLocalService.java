package com.egakat.econnect.maestros.client.service.api;

import java.util.List;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.PuntoDto;
import com.egakat.econnect.maestros.dto.TerceroDto;

public interface TerceroLocalService extends LocalQueryService<TerceroDto, Long> {

	PuntoDto getPuntoByTerceroIdAndPuntoCodigo(long tercero, String codigo);

	List<PuntoDto> getPuntosByTerceroIdAndCiudadId(long tercero, long ciudad);
}
