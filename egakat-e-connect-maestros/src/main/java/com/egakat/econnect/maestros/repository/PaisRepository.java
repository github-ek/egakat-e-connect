package com.egakat.econnect.maestros.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.Pais;

public interface PaisRepository extends IdentifiedDomainObjectRepository<Pais, Long>, QueryByCodigo<Pais, Long> {

}
