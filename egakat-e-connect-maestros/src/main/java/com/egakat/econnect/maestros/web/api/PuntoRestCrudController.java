package com.egakat.econnect.maestros.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.PuntoDto;
import com.egakat.econnect.maestros.service.api.PuntoCrudService;

@RestController
@RequestMapping(value = RestConstants.punto, produces = MediaType.APPLICATION_JSON_VALUE)
public class PuntoRestCrudController extends CrudRestController<PuntoDto, Long> {

	@Autowired
	private PuntoCrudService service;

	@Override
	protected PuntoCrudService getService() {
		return service;
	}
}
