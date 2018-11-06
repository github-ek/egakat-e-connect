package com.egakat.econnect.maestros.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.BodegaDto;

public interface BodegaLocalService extends LocalQueryService<BodegaDto, Long> {

	BodegaDto getByCodigo(String codigo);
}