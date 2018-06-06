package com.egakat.econnect.conciliaciones.client.service.api.lookup;

import org.springframework.cache.annotation.Cacheable;

public interface ConciliacionesLookUpService {
	
	@Cacheable(cacheNames = "estados-conciliacion", sync = true)
	Long findEstadoConciliacionIdByEstadoConciliacionCodigo(String codigo);
}