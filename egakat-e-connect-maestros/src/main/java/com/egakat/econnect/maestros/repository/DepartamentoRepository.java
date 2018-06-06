package com.egakat.econnect.maestros.repository;

import java.util.List;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.Departamento;

public interface DepartamentoRepository extends IdentifiedDomainObjectRepository<Departamento, Long>, QueryByCodigo<Departamento, Long> {

	List<Departamento> findAllByPaisId(Long idPais);
	
}
