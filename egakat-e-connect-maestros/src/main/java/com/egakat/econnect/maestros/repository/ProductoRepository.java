package com.egakat.econnect.maestros.repository;

import java.util.List;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.econnect.maestros.domain.Producto;

public interface ProductoRepository extends IdentifiedDomainObjectRepository<Producto, Long> {
	
	Producto findOneByClienteIdAndCodigo(Long idCliente, String codigo);

	List<Producto> findAllByClienteId(Long idCliente);
}
