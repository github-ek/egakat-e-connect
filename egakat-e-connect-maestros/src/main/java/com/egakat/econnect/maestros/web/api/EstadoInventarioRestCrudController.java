package com.egakat.econnect.maestros.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.EstadoInventarioDto;
import com.egakat.econnect.maestros.service.api.EstadoInventarioCrudService;

@RestController
@RequestMapping(value = RestConstants.estadoInventario, produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoInventarioRestCrudController
		extends CrudRestController<EstadoInventarioDto, String> {
	@Autowired
	private EstadoInventarioCrudService service;

	@Override
	protected EstadoInventarioCrudService getService() {
		return service;
	}
}
