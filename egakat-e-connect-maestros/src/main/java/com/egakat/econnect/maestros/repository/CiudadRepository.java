package com.egakat.econnect.maestros.repository;

import java.util.List;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.Ciudad;

public interface CiudadRepository extends IdentifiedDomainObjectRepository<Ciudad, Long>, QueryByCodigo<Ciudad, Long> {
	
	Ciudad findOneByNombreAlterno(String nombreAlterno);
	
	List<Ciudad> findAllByDepartamentoId(Long idDepartamento);
}
