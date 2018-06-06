package com.egakat.econnect.maestros.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.BodegaDto;

public interface BodegaCrudService extends CrudService<BodegaDto, Long>, QueryByCodigoService<BodegaDto, Long> {
}
