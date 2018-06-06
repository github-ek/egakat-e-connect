package com.egakat.econnect.maestros.repository;

import java.util.List;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.econnect.maestros.domain.Direccion;

public interface DireccionRepository extends IdentifiedDomainObjectRepository<Direccion, Long> {

	List<Direccion> findAllByClienteIdAndCiudadId(long cliente, long ciudad);
	
	Direccion findOneByClienteIdAndCiudadIdAndDireccion(long cliente, long ciudad,String direccion);
}
