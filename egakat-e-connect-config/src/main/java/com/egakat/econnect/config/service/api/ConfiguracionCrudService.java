package com.egakat.econnect.config.service.api;

import java.util.List;
import java.util.Optional;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.econnect.config.dto.ConfiguracionDto;

public interface ConfiguracionCrudService extends CrudService<ConfiguracionDto,  Long> {
	Optional<ConfiguracionDto> findOneByGrupoConfiguracionIdAndCodigo(Long grupoConfiguracion, String codigo);

	List<ConfiguracionDto> findAllByGrupoConfiguracionId(long grupoConfiguracion);
}
