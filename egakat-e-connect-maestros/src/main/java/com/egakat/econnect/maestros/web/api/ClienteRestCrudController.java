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
import com.egakat.econnect.maestros.dto.ClienteDto;
import com.egakat.econnect.maestros.dto.DireccionDto;
import com.egakat.econnect.maestros.dto.ProductoDto;
import com.egakat.econnect.maestros.dto.ServicioDto;
import com.egakat.econnect.maestros.dto.TerceroDto;
import com.egakat.econnect.maestros.service.api.ClienteCrudService;
import com.egakat.econnect.maestros.service.api.DireccionCrudService;
import com.egakat.econnect.maestros.service.api.ProductoCrudService;
import com.egakat.econnect.maestros.service.api.TerceroCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.cliente, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteRestCrudController extends CrudRestController<ClienteDto, Long> {

	@Autowired
	private ProductoCrudService productoCrudService;

	@Autowired
	private TerceroCrudService terceroCrudService;

	@Autowired
	private DireccionCrudService direccionCrudService;

	@Autowired
	private ClienteCrudService service;

	@Override
	protected ClienteCrudService getService() {
		return service;
	}

	@GetMapping(params = { "codigo" })
	public ResponseEntity<ClienteDto> get(@RequestParam String codigo) {
		val result = getService().findByCodigo(codigo);

		if (!result.isPresent()) {
			throw new NotFoundException();
		}

		return ResponseEntity.ok(result.get());
	}

	@GetMapping(params = "numeroIdentificacion")
	public ResponseEntity<ClienteDto> getByNumeroIdentificacion(@RequestParam String numeroIdentificacion) {
		val result = getService().findOneByNumeroIdentificacion(numeroIdentificacion);
		return ResponseEntity.ok(result);
	}

	@GetMapping(params = "codigoAlternoWms")
	public ResponseEntity<ClienteDto> getByCodigoAlternoWms(@RequestParam String codigoAlternoWms) {
		val result = getService().findOneByCodigoWms(codigoAlternoWms);
		return ResponseEntity.ok(result);
	}

	@GetMapping(RestConstants.serviciosByCliente)
	public ResponseEntity<List<ServicioDto>> getServicios(@PathVariable long id) {
		val result = getService().findAllServiciosByClienteId(id);
		return ResponseEntity.ok(result);
	}

	@GetMapping(RestConstants.productosByCliente)
	public ResponseEntity<List<ProductoDto>> getProductos(@PathVariable long id) {
		val result = productoCrudService.findAllByClienteId(id);
		return ResponseEntity.ok(result);
	}

	@GetMapping(path = RestConstants.productosByCliente, params = "codigo")
	public ResponseEntity<ProductoDto> getProductoByClienteIdAndCodigo(@PathVariable long id, String codigo) {
		val result = productoCrudService.findOneByClienteIdAndCodigo(id, codigo);
		if (!result.isPresent()) {
			throw new NotFoundException();
		}
		return ResponseEntity.ok(result.get());
	}

	@GetMapping(RestConstants.tercerosByCliente)
	public ResponseEntity<List<TerceroDto>> getTerceros(@PathVariable long id) {
		val result = terceroCrudService.finaAllByClienteId(id);
		return ResponseEntity.ok(result);
	}

	@GetMapping(path = RestConstants.tercerosByCliente, params = "numeroIdentificacion")
	public ResponseEntity<TerceroDto> getTerceros(@PathVariable long id, @RequestParam String numeroIdentificacion) {
		val result = terceroCrudService.findOneByClienteIdAndNumeroIdentificacion(id, numeroIdentificacion);
		if (!result.isPresent()) {
			throw new NotFoundException();
		}
		return ResponseEntity.ok(result.get());
	}

	@GetMapping(path = RestConstants.direccionesByCliente, params = { "ciudad" })
	public ResponseEntity<List<DireccionDto>> getDireccionesByClienteIdAndCiudadId(@PathVariable long cliente,
			@RequestParam long ciudad) {
		List<DireccionDto> result = direccionCrudService.findAllByClienteIdAndCiudadId(cliente, ciudad);
		return ResponseEntity.ok(result);
	}

	@GetMapping(path = RestConstants.direccionesByCliente, params = { "ciudad", "direccion" })
	public ResponseEntity<DireccionDto> getDireccionesByClienteIdAndCiudadIdAndDireccion(@PathVariable long cliente,
			@RequestParam long ciudad, @RequestParam String direccion) {
		val result = direccionCrudService.findOneByClienteIdAndCiudadIdAndDireccion(cliente, ciudad, direccion);
		if (!result.isPresent()) {
			throw new NotFoundException();
		}
		return ResponseEntity.ok(result.get());
	}
}
