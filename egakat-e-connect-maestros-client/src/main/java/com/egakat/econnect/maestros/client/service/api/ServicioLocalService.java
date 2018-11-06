package com.egakat.econnect.maestros.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.ServicioDto;

public interface ServicioLocalService extends LocalQueryService<ServicioDto, Long> {

	ServicioDto getByCodigo(String codigo);
}
