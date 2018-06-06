package com.egakat.econnect.maestros.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.core.web.api.controllers.NotFoundException;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.CiudadDto;
import com.egakat.econnect.maestros.dto.DepartamentoDto;
import com.egakat.econnect.maestros.service.api.CiudadCrudService;
import com.egakat.econnect.maestros.service.api.DepartamentoCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.departamento, produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartamentoRestCrudController extends CrudRestController<DepartamentoDto, Long> {

	@Autowired
	private CiudadCrudService ciudadCrudService;

	@Autowired
	private DepartamentoCrudService service;

	@Override
	protected DepartamentoCrudService getService() {
		return service;
	}

	@GetMapping(params = { "codigo" })
	public ResponseEntity<DepartamentoDto> get(@RequestParam String codigo) {
		val result = getService().findByCodigo(codigo);

		if (!result.isPresent()) {
			throw new NotFoundException();
		}

		return ResponseEntity.ok(result.get());
	}

	@GetMapping("{id}/ciudades")
	public ResponseEntity<List<CiudadDto>> get(@PathVariable long id) {
		val result = ciudadCrudService.findAllByDepartamentoId(id);
		return ResponseEntity.ok(result);
	}
}
