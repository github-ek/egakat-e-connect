package com.egakat.econnect.maestros.repository;

import java.util.List;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.LineaNegocio;

public interface LineaNegocioRepository extends IdentifiedDomainObjectRepository<LineaNegocio, Long>, QueryByCodigo<LineaNegocio, Long> {

	List<LineaNegocio> findAllByUnidadNegocioId(long unidadNegocio);
}
