package com.egakat.econnect.maestros.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.LineaNegocioDto;

public interface LineaNegocioLocalService extends LocalQueryService<LineaNegocioDto, Long> {

	LineaNegocioDto getByCodigo(String codigo);
}
