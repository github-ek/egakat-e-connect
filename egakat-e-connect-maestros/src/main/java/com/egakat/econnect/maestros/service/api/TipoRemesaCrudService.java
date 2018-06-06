package com.egakat.econnect.maestros.service.api;

import java.util.List;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.TipoRemesaDto;

public interface TipoRemesaCrudService
		extends CrudService<TipoRemesaDto, Long>, QueryByCodigoService<TipoRemesaDto, Long> {

	List<TipoRemesaDto> findAllByUnidadNegocioId(long unidadNegocio);
}