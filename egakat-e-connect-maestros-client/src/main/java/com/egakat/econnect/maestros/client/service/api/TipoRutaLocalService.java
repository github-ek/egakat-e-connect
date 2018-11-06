package com.egakat.econnect.maestros.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.TipoRutaDto;

public interface TipoRutaLocalService extends LocalQueryService<TipoRutaDto, Long> {

	TipoRutaDto getByCodigo(String codigo);
}
