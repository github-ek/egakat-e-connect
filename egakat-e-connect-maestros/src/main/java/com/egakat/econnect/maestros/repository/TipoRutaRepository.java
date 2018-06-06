package com.egakat.econnect.maestros.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.TipoRuta;

public interface TipoRutaRepository extends IdentifiedDomainObjectRepository<TipoRuta, Long>, QueryByCodigo<TipoRuta, Long> {
}
