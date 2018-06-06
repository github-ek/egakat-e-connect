package com.egakat.econnect.config.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.config.dto.GrupoConfiguracionDto;

public interface GrupoConfiguracionCrudService extends CrudService<GrupoConfiguracionDto, Long>,
		QueryByCodigoService<GrupoConfiguracionDto, Long> {
}