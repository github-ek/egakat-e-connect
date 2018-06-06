package com.egakat.econnect.config.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.config.domain.GrupoConfiguracion;

public interface GrupoConfiguracionRepository extends IdentifiedDomainObjectRepository<GrupoConfiguracion, Long>, QueryByCodigo<GrupoConfiguracion, Long> {

}
