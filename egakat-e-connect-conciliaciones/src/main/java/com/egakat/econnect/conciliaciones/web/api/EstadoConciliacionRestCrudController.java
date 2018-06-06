package com.egakat.econnect.conciliaciones.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.core.web.api.controllers.NotFoundException;
import com.egakat.econnect.conciliaciones.constants.RestConstants;
import com.egakat.econnect.conciliaciones.dto.EstadoConciliacionDto;
import com.egakat.econnect.conciliaciones.service.api.EstadoConciliacionCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.estadoConciliacion, produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoConciliacionRestCrudController extends CrudRestController<EstadoConciliacionDto, Long> {
	@Autowired
	private EstadoConciliacionCrudService service;

	@Override
	protected EstadoConciliacionCrudService getService() {
		return service;
	}

	@GetMapping(params = { "codigo" })
	public ResponseEntity<EstadoConciliacionDto> get(@RequestParam String codigo) {
		val result = getService().findByCodigo(codigo);

		if (!result.isPresent()) {
			throw new NotFoundException();
		}

		return ResponseEntity.ok(result.get());
	}
}
