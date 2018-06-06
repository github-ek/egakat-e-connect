package com.egakat.econnect.maestros.service.api;

import java.util.List;
import java.util.Optional;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.CiudadDto;

public interface CiudadCrudService
		extends CrudService<CiudadDto, Long>, QueryByCodigoService<CiudadDto, Long> {

	Optional<CiudadDto> findOneByNombreAlterno(String nombreAlterno);

	List<CiudadDto> findAllByDepartamentoId(long departamento);
}
