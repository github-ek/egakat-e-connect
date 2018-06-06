package com.egakat.econnect.maestros.service.api;

import java.util.List;
import java.util.Optional;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.econnect.maestros.dto.DireccionDto;

public interface DireccionCrudService extends CrudService<DireccionDto, Long> {

	List<DireccionDto> findAllByClienteIdAndCiudadId(long cliente, long ciudad);

	Optional<DireccionDto> findOneByClienteIdAndCiudadIdAndDireccion(long cliente, long ciudad, String direccion);
}
