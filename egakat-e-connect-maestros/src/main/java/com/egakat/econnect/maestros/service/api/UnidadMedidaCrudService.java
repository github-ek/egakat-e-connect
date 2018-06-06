package com.egakat.econnect.maestros.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.UnidadMedidaDto;

public interface UnidadMedidaCrudService
		extends CrudService<UnidadMedidaDto, Long>, QueryByCodigoService<UnidadMedidaDto, Long> {
}