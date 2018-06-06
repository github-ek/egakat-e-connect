package com.egakat.econnect.maestros.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.CanalDto;

public interface CanalLocalService extends LocalQueryService<CanalDto, Long> {

	CanalDto getByCodigo(String codigo);

}
