package com.egakat.econnect.maestros.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.DireccionDto;
import com.egakat.econnect.maestros.service.api.DireccionCrudService;

@RestController
@RequestMapping(value = RestConstants.direccion, produces = MediaType.APPLICATION_JSON_VALUE)
public class DireccionRestCrudController extends CrudRestController<DireccionDto, Long> {
	@Autowired
	private DireccionCrudService service;

	@Override
	protected DireccionCrudService getService() {
		return service;
	}
}
