package com.egakat.econnect.config.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egakat.core.web.api.controllers.NotFoundException;
import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.econnect.config.constants.RestConstants;
import com.egakat.econnect.config.dto.ConfiguracionDto;
import com.egakat.econnect.config.dto.GrupoConfiguracionDto;
import com.egakat.econnect.config.service.api.ConfiguracionCrudService;
import com.egakat.econnect.config.service.api.GrupoConfiguracionCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.grupoConfiguracion, produces = MediaType.APPLICATION_JSON_VALUE)
public class GrupoConfiguracionRestCrudController extends CrudRestController<GrupoConfiguracionDto, Long> {

	@Autowired
	private ConfiguracionCrudService configuracionCrudservice;

	@Autowired
	private GrupoConfiguracionCrudService service;

	@Override
	protected GrupoConfiguracionCrudService getService() {
		return service;
	}

	@GetMapping(params = { "codigo" })
	public ResponseEntity<GrupoConfiguracionDto> get(@RequestParam String codigo) {
		val result = getService().findByCodigo(codigo);

		if (!result.isPresent()) {
			throw new NotFoundException();
		}

		return ResponseEntity.ok(result.get());
	}

	@GetMapping(RestConstants.configuracionesByGrupoConfiguracion)
	public ResponseEntity<List<ConfiguracionDto>> get(@PathVariable long id) {
		val result = configuracionCrudservice.findAllByGrupoConfiguracionId(id);
		return ResponseEntity.ok(result);
	}

	@GetMapping(path = RestConstants.configuracionesByGrupoConfiguracion, params = { "codigo" })
	public ResponseEntity<ConfiguracionDto> getMapaByCodigo(@PathVariable long id, @RequestParam String codigo) {
		val result = configuracionCrudservice.findOneByGrupoConfiguracionIdAndCodigo(id, codigo);
		if (!result.isPresent()) {
			throw new NotFoundException();
		}
		return ResponseEntity.ok(result.get());
	}
}
