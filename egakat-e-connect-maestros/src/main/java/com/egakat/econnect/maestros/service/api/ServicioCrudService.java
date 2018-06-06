package com.egakat.econnect.maestros.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.ServicioDto;

public interface ServicioCrudService
		extends CrudService<ServicioDto, Long>, QueryByCodigoService<ServicioDto, Long> {

}
