package com.egakat.econnect.maestros.client.service.api;

import java.util.List;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.CiudadDto;
import com.egakat.econnect.maestros.dto.DepartamentoDto;

public interface DepartamentoLocalService extends LocalQueryService<DepartamentoDto, Long> {

	DepartamentoDto getByCodigo(String codigo);

	List<CiudadDto> getCiudadesByDepartamentoId(long departamento);
}
