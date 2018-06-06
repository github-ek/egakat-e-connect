package com.egakat.econnect.maestros.repository;

import java.util.List;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.econnect.maestros.domain.Punto;

public interface PuntoRepository extends IdentifiedDomainObjectRepository<Punto, Long> {

	Punto findOneByTerceroIdAndCodigo(long tercero, String codigo);
	
	List<Punto> findAllByTerceroIdAndCiudadId(long tercero, long ciudad);
}
