package com.egakat.econnect.maestros.repository;

import java.util.List;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.TipoRemesa;

public interface TipoRemesaRepository extends IdentifiedDomainObjectRepository<TipoRemesa, Long>, QueryByCodigo<TipoRemesa, Long> {

	List<TipoRemesa> findAllByUnidadNegocioId(long unidadNegocio);
}
