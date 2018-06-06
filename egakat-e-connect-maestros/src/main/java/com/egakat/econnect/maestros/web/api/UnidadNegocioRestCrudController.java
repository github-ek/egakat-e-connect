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
import com.egakat.econnect.maestros.dto.LineaNegocioDto;
import com.egakat.econnect.maestros.dto.TipoRemesaDto;
import com.egakat.econnect.maestros.dto.UnidadNegocioDto;
import com.egakat.econnect.maestros.service.api.LineaNegocioCrudService;
import com.egakat.econnect.maestros.service.api.TipoRemesaCrudService;
import com.egakat.econnect.maestros.service.api.UnidadNegocioCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.unidadNegocio, produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadNegocioRestCrudController extends CrudRestController<UnidadNegocioDto, Long> {
	@Autowired
	private LineaNegocioCrudService lineaNegocioCrudService;

	@Autowired
	private TipoRemesaCrudService tipoRemesaCrudService;

	@Autowired
	private UnidadNegocioCrudService service;

	@Override
	protected UnidadNegocioCrudService getService() {
		return service;
	}

	@GetMapping(params = { "codigo" })
	public ResponseEntity<UnidadNegocioDto> get(@RequestParam String codigo) {
		val result = getService().findByCodigo(codigo);

		if (!result.isPresent()) {
			throw new NotFoundException();
		}

		return ResponseEntity.ok(result.get());
	}

	@GetMapping(RestConstants.lineaNegocio)
	public ResponseEntity<List<LineaNegocioDto>> getLineasNegocio(@PathVariable long id) {
		val result = lineaNegocioCrudService.findAllByUnidadNegocioId(id);
		return ResponseEntity.ok(result);
	}

	@GetMapping(RestConstants.tiposRemesaByUnidadNegocio)
	public ResponseEntity<List<TipoRemesaDto>> getTiposRemesa(@PathVariable long id) {
		List<TipoRemesaDto> result = tipoRemesaCrudService.findAllByUnidadNegocioId(id);
		return ResponseEntity.ok(result);
	}
}
