package com.egakat.econnect.maestros.service.api;

import java.util.List;
import java.util.Optional;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.econnect.maestros.dto.PuntoDto;

public interface PuntoCrudService extends CrudService<PuntoDto, Long> {

	Optional<PuntoDto> findOneByTerceroIdAndCodigo(long tercero, String codigo);

	List<PuntoDto> findAllByTerceroIdAndCiudadId(long tercero, long ciudad);
}
