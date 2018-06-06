package com.egakat.econnect.maestros.service.api;

import java.util.List;
import java.util.Optional;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.econnect.maestros.dto.TerceroDto;

public interface TerceroCrudService extends CrudService<TerceroDto, Long> {

	Optional<TerceroDto> findOneByClienteIdAndNumeroIdentificacion(long cliente, String numeroIdentificacion);

	List<TerceroDto> finaAllByClienteId(long cliente);
}
