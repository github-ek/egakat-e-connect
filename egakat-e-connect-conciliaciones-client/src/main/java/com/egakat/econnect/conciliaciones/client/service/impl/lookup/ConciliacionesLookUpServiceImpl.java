package com.egakat.econnect.conciliaciones.client.service.impl.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.egakat.econnect.conciliaciones.client.service.api.EstadoConciliacionLocalService;
import com.egakat.econnect.conciliaciones.client.service.api.lookup.ConciliacionesLookUpService;

import lombok.val;

@Service
public class ConciliacionesLookUpServiceImpl implements ConciliacionesLookUpService {

	@Autowired
	private EstadoConciliacionLocalService estadoConciliacionLocalService;

	@Override
	public Long findEstadoConciliacionIdByEstadoConciliacionCodigo(String codigo) {
		Long result = null;
		try {
			val model = estadoConciliacionLocalService.getByCodigo(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	private void throwIf(HttpClientErrorException e) {
		if (e.getRawStatusCode() == 404) {
			return;
		}
		throw e;
	}
}
