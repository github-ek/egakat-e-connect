package com.egakat.econnect.maestros.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.UnidadNegocio;

public interface UnidadNegocioRepository extends IdentifiedDomainObjectRepository<UnidadNegocio, Long>, QueryByCodigo<UnidadNegocio, Long> {
}
