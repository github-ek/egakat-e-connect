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
import com.egakat.econnect.maestros.constants.RestConstants;
import com.egakat.econnect.maestros.dto.ProductoAtributoDto;
import com.egakat.econnect.maestros.dto.ProductoCodigoDto;
import com.egakat.econnect.maestros.dto.ProductoDto;
import com.egakat.econnect.maestros.dto.ProductoMedidaDto;
import com.egakat.econnect.maestros.service.api.ProductoCrudService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.producto, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductoRestCrudController extends CrudRestController<ProductoDto, Long> {
	@Autowired
	private ProductoCrudService service;

	@Override
	protected ProductoCrudService getService() {
		return service;
	}

	@GetMapping(RestConstants.codigosByProducto)
	public ResponseEntity<List<ProductoCodigoDto>> getCodigos(@PathVariable long id) {
		val result = getService().findAllCodigosByProductoId(id);
		return ResponseEntity.ok(result);
	}

	@GetMapping(RestConstants.atributosByProducto)
	public ResponseEntity<List<ProductoAtributoDto>> getAtributos(@PathVariable long id) {
		val result = getService().findAllAtributosByProductoId(id);
		return ResponseEntity.ok(result);
	}

	@GetMapping(path = RestConstants.atributosByProducto, params = { "bodega" })
	public ResponseEntity<List<ProductoAtributoDto>> getAtributosByBodega(@PathVariable long id,
			@RequestParam long bodega) {
		val result = getService().findAllAtributosByProductoIdAndBodegaId(id, bodega);
		return ResponseEntity.ok(result);
	}

	@GetMapping(RestConstants.medidasByProducto)
	public ResponseEntity<List<ProductoMedidaDto>> getMedidas(@PathVariable long id) {
		val result = getService().findAllMedidasByProductoId(id);
		return ResponseEntity.ok(result);
	}

	@GetMapping(path = RestConstants.medidasByProducto, params = { "bodega" })
	public ResponseEntity<List<ProductoMedidaDto>> getMedidasByBodega(@PathVariable long id,
			@RequestParam long bodega) {
		val result = getService().findAllMedidasByProductoIdAndBodegaId(id, bodega);
		return ResponseEntity.ok(result);
	}
}
