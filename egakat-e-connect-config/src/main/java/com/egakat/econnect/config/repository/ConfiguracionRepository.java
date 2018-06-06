package com.egakat.econnect.config.repository;

import java.util.List;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.econnect.config.domain.Configuracion;

public interface ConfiguracionRepository extends IdentifiedDomainObjectRepository<Configuracion, Long> {
	Configuracion findOneByGrupoConfiguracionIdAndCodigo(Long grupoConfiguracion, String codigo);

	Configuracion findOneByCodigo(String codigo);
	
	List<Configuracion> findAllByGrupoConfiguracionId(long grupoConfiguracion);
}
