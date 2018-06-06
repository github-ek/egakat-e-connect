package com.egakat.econnect.config.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.econnect.config.constants.RestConstants;
import com.egakat.econnect.config.dto.ConfiguracionDto;
import com.egakat.econnect.config.service.api.ConfiguracionCrudService;

@RestController
@RequestMapping(value = RestConstants.configuracion, produces = MediaType.APPLICATION_JSON_VALUE)
public class ConfiguracionRestCrudController extends CrudRestController<ConfiguracionDto, Long> {

	@Autowired
	private ConfiguracionCrudService service;

	@Override
	protected ConfiguracionCrudService getService() {
		return service;
	}
}
