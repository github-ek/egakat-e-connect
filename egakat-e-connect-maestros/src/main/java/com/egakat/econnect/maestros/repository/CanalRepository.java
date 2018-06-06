package com.egakat.econnect.maestros.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.Canal;

public interface CanalRepository extends IdentifiedDomainObjectRepository<Canal, Long>, QueryByCodigo<Canal, Long> {
}
