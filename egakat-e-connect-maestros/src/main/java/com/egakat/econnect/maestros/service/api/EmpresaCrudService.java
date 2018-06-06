package com.egakat.econnect.maestros.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.EmpresaDto;

public interface EmpresaCrudService
		extends CrudService<EmpresaDto, Long>, QueryByCodigoService<EmpresaDto, Long> {
}
