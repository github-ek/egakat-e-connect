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
import com.egakat.econnect.maestros.dto.DepartamentoDto;
import com.egakat.econnect.maestros.dto.PaisDto;
import com.egakat.econnect.maestros.service.api.DepartamentoCrudService;
import com.egakat.econnect.maestros.service.api.PaisCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.pais, produces = MediaType.APPLICATION_JSON_VALUE)
public class PaisRestCrudController extends CrudRestController<PaisDto, Long> {
	
	@Autowired
	private DepartamentoCrudService departamentoCrudService;

	@Autowired
	private PaisCrudService service;

	@Override
	protected PaisCrudService getService() {
		return service;
	}
	
	@GetMapping(params = { "codigo" })
	public ResponseEntity<PaisDto> get(@RequestParam String codigo) {
		val result = getService().findByCodigo(codigo);

		if (!result.isPresent()) {
			throw new NotFoundException();
		}

		return ResponseEntity.ok(result.get());
	}
	
	@GetMapping(RestConstants.departamentosByPais)
	public ResponseEntity<List<DepartamentoDto>> get(@PathVariable long id) {
		val result = departamentoCrudService.findAllByPaisId(id);
		return ResponseEntity.ok(result);
	}
}
