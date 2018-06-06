package com.egakat.econnect.maestros.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.core.web.api.controllers.NotFoundException;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.UnidadMedidaDto;
import com.egakat.econnect.maestros.service.api.UnidadMedidaCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.unidadMedida, produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadMedidaRestCrudController extends CrudRestController<UnidadMedidaDto, Long> {
	@Autowired
	private UnidadMedidaCrudService service;

	@Override
	protected UnidadMedidaCrudService getService() {
		return service;
	}

	@GetMapping(params = { "codigo" })
	public ResponseEntity<UnidadMedidaDto> get(@RequestParam String codigo) {
		val result = getService().findByCodigo(codigo);

		if (!result.isPresent()) {
			throw new NotFoundException();
		}

		return ResponseEntity.ok(result.get());
	}
}
