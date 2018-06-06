package com.egakat.econnect.maestros.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.EmpresaDto;

public interface EmpresaLocalService extends LocalQueryService<EmpresaDto, Long> {

	EmpresaDto getByCodigo(String codigo);
}
