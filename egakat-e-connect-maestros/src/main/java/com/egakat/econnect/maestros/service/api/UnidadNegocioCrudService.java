package com.egakat.econnect.maestros.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.UnidadNegocioDto;

public interface UnidadNegocioCrudService
		extends CrudService<UnidadNegocioDto, Long>, QueryByCodigoService<UnidadNegocioDto, Long> {
}