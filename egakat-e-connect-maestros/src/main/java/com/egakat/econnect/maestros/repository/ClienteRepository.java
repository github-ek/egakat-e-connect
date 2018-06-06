package com.egakat.econnect.maestros.repository;

import java.util.Optional;

import com.egakat.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.egakat.core.data.jpa.repository.QueryByCodigo;
import com.egakat.econnect.maestros.domain.Cliente;

public interface ClienteRepository extends IdentifiedDomainObjectRepository<Cliente, Long>, QueryByCodigo<Cliente, Long> {

	Optional<Cliente> findOneByNumeroIdentificacion(String numeroIdentificacion);
	
	Optional<Cliente> findOneByCodigoAlternoWms(String codigoAlternoWms);
}
