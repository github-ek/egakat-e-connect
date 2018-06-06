package com.egakat.econnect.maestros.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.NotFoundException;
import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.CiudadDto;
import com.egakat.econnect.maestros.service.api.CiudadCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.ciudad, produces = MediaType.APPLICATION_JSON_VALUE)
public class CiudadRestCrudController extends CrudRestController<CiudadDto, Long> {
	
	@Autowired
	private CiudadCrudService service;

	@Override
	protected CiudadCrudService getService() {
		return service;
	}
	
	@GetMapping(params = { "codigo" })
	public ResponseEntity<CiudadDto> get(@RequestParam String codigo) {
		val result = getService().findByCodigo(codigo);

		if (!result.isPresent()) {
			throw new NotFoundException();
		}

		return ResponseEntity.ok(result.get());
	}
	
	@GetMapping(params = { "nombreAlterno" })
	public ResponseEntity<CiudadDto> getByNombreAlterno(@RequestParam String nombreAlterno) {
		val result = getService().findOneByNombreAlterno(nombreAlterno);
		if (!result.isPresent()) {
			throw new NotFoundException();
		}
		return ResponseEntity.ok(result.get());
	}

}
