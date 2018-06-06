package com.egakat.econnect.maestros.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.SubestadoInventarioDto;
import com.egakat.econnect.maestros.service.api.SubestadoInventarioCrudService;

@RestController
@RequestMapping(value = RestConstants.subestadoInventario, produces = MediaType.APPLICATION_JSON_VALUE)
public class SubestadoInventarioRestCrudController
		extends CrudRestController<SubestadoInventarioDto, String> {
	@Autowired
	private SubestadoInventarioCrudService service;

	@Override
	protected SubestadoInventarioCrudService getService() {
		return service;
	}
}
