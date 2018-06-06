package com.egakat.econnect.maestros.service.api;

import java.util.List;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.ClienteDto;
import com.egakat.econnect.maestros.dto.ServicioDto;

public interface ClienteCrudService
		extends CrudService<ClienteDto, Long>, QueryByCodigoService<ClienteDto, Long> {

	ClienteDto findOneByNumeroIdentificacion(String numeroIdentificacion);

	ClienteDto findOneByCodigoWms(String codigo);

	List<ServicioDto> findAllServiciosByClienteId(long cliente);
}
