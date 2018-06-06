package com.egakat.econnect.conciliaciones.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.conciliaciones.dto.EstadoConciliacionDto;

public interface EstadoConciliacionCrudService
		extends CrudService<EstadoConciliacionDto, Long>, QueryByCodigoService<EstadoConciliacionDto, Long> {
}
