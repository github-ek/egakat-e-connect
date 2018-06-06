package com.egakat.econnect.maestros.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.Bodega;

public interface BodegaRepository extends IdentifiedDomainObjectRepository<Bodega, Long>, QueryByCodigo<Bodega, Long> {
}
