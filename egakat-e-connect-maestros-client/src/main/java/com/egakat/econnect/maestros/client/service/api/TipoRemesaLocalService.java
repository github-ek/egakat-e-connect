package com.egakat.econnect.maestros.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.TipoRemesaDto;

public interface TipoRemesaLocalService extends LocalQueryService<TipoRemesaDto, Long> {

	TipoRemesaDto getByCodigo(String codigo);
}
