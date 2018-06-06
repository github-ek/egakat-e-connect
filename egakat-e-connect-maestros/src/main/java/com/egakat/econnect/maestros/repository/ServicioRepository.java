package com.egakat.econnect.maestros.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.Servicio;

public interface ServicioRepository extends IdentifiedDomainObjectRepository<Servicio, Long>, QueryByCodigo<Servicio, Long> {

}
