package com.egakat.econnect.conciliaciones.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.conciliaciones.dto.EstadoConciliacionDto;

public interface EstadoConciliacionLocalService extends LocalQueryService<EstadoConciliacionDto, Long> {
	EstadoConciliacionDto getByCodigo(String codigo);
}
