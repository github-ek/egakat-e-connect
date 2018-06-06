package com.egakat.econnect.maestros.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.CanalDto;

public interface CanalCrudService extends CrudService<CanalDto, Long>, QueryByCodigoService<CanalDto, Long> {
}
