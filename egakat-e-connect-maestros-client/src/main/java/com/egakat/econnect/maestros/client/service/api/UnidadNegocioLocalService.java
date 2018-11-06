package com.egakat.econnect.maestros.client.service.api;

import java.util.List;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.LineaNegocioDto;
import com.egakat.econnect.maestros.dto.TipoRemesaDto;
import com.egakat.econnect.maestros.dto.UnidadNegocioDto;

public interface UnidadNegocioLocalService extends LocalQueryService<UnidadNegocioDto, Long> {

	UnidadNegocioDto getByCodigo(String codigo);

	List<LineaNegocioDto> getLineasNegocioByUnidadNegocioId(long unidadNegocio);

	List<TipoRemesaDto> getTiposRemesaByUnidadNegocioId(long unidadNegocio);
}
