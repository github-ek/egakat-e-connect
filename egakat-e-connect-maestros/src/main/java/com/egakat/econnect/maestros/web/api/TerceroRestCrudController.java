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

import com.egakat.core.web.api.controllers.NotFoundException;
import com.egakat.core.web.api.controllers.CrudRestController;
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.PuntoDto;
import com.egakat.econnect.maestros.dto.TerceroDto;
import com.egakat.econnect.maestros.service.api.PuntoCrudService;
import com.egakat.econnect.maestros.service.api.TerceroCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.tercero, produces = MediaType.APPLICATION_JSON_VALUE)
public class TerceroRestCrudController extends CrudRestController<TerceroDto, Long> {
	@Autowired
	private PuntoCrudService puntoCrudService;

	@Autowired
	private TerceroCrudService service;

	@Override
	protected TerceroCrudService getService() {
		return service;
	}

	@GetMapping(path = RestConstants.puntosByTercero, params = { "codigo" })
	public ResponseEntity<PuntoDto> getPuntoByCodigo(@PathVariable long id, @RequestParam String codigo) {
		val result = puntoCrudService.findOneByTerceroIdAndCodigo(id, codigo);
		if (!result.isPresent()) {
			throw new NotFoundException();
		}
		return ResponseEntity.ok(result.get());
	}

	@GetMapping(path = RestConstants.puntosByTercero, params = { "ciudad" })
	public ResponseEntity<List<PuntoDto>> getPuntosByCiudad(@PathVariable long id, @RequestParam long ciudad) {
		val result = puntoCrudService.findAllByTerceroIdAndCiudadId(id, ciudad);
		return ResponseEntity.ok(result);
	}
}
