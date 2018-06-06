package com.egakat.econnect.maestros.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.PaisDto;

public interface PaisCrudService extends CrudService<PaisDto, Long>, QueryByCodigoService<PaisDto, Long> {

}
