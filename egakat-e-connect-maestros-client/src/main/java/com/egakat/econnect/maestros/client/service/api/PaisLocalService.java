package com.egakat.econnect.maestros.client.service.api;

import java.util.List;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.DepartamentoDto;
import com.egakat.econnect.maestros.dto.PaisDto;

public interface PaisLocalService extends LocalQueryService<PaisDto, Long> {

	PaisDto getByCodigo(String codigo);

	List<DepartamentoDto> getDepartamentosByPaisId(long pais);
}
