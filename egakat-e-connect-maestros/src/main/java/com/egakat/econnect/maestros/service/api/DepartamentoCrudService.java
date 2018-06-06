package com.egakat.econnect.maestros.service.api;

import java.util.List;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.DepartamentoDto;

public interface DepartamentoCrudService
		extends CrudService<DepartamentoDto, Long>, QueryByCodigoService<DepartamentoDto, Long> {

	List<DepartamentoDto> findAllByPaisId(long pais);
}
