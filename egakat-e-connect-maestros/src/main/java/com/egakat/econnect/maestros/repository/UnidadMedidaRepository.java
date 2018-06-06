package com.egakat.econnect.maestros.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.UnidadMedida;

public interface UnidadMedidaRepository extends IdentifiedDomainObjectRepository<UnidadMedida, Long>, QueryByCodigo<UnidadMedida, Long> {
}
