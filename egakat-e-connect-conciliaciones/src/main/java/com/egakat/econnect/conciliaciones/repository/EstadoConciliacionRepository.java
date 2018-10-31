package com.egakat.econnect.conciliaciones.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.conciliaciones.domain.EstadoConciliacion;

public interface EstadoConciliacionRepository
		extends IdentifiedDomainObjectRepository<EstadoConciliacion, Long>, QueryByCodigo<EstadoConciliacion, Long> {
}
