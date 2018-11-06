package com.egakat.econnect.maestros.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.UnidadMedidaDto;

public interface UnidadMedidaLocalService extends LocalQueryService<UnidadMedidaDto, Long> {

	UnidadMedidaDto getByCodigo(String codigo);
}
