package com.egakat.econnect.maestros.repository;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.Empresa;

public interface EmpresaRepository extends IdentifiedDomainObjectRepository<Empresa, Long>, QueryByCodigo<Empresa, Long> {
}
