package com.egakat.econnect.conciliaciones.client.service.api.lookup;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.egakat.core.web.client.service.api.CacheEvictSupported;

public interface ConciliacionesLookUpService extends CacheEvictSupported {

	@Cacheable(cacheNames = "estados-conciliacion", sync = true)
	Long findEstadoConciliacionIdByEstadoConciliacionCodigo(String codigo);

	@CacheEvict(cacheNames = { "estados-conciliacion" }, allEntries = true)
	void cacheEvict();
}