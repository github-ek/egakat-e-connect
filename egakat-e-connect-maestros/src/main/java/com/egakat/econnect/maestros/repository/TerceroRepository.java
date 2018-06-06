package com.egakat.econnect.maestros.repository;

import java.util.List;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.econnect.maestros.domain.Tercero;

public interface TerceroRepository extends IdentifiedDomainObjectRepository<Tercero, Long> {
	
	Tercero findOneByClienteIdAndNumeroIdentificacion(Long idCliente,String numeroIdentificacion);

	List<Tercero> findAllByClienteId(long idCliente);
}

