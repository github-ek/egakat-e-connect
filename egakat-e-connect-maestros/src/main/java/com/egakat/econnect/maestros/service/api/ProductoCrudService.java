package com.egakat.econnect.maestros.service.api;

import java.util.List;
import java.util.Optional;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.econnect.maestros.dto.ProductoAtributoDto;
import com.egakat.econnect.maestros.dto.ProductoCodigoDto;
import com.egakat.econnect.maestros.dto.ProductoDto;
import com.egakat.econnect.maestros.dto.ProductoMedidaDto;

public interface ProductoCrudService extends CrudService<ProductoDto, Long> {

	Optional<ProductoDto> findOneByClienteIdAndCodigo(long cliente, String codigo);

	List<ProductoDto> findAllByClienteId(long cliente);

	List<ProductoCodigoDto> findAllCodigosByProductoId(long producto);

	List<ProductoAtributoDto> findAllAtributosByProductoId(long producto);

	List<ProductoAtributoDto> findAllAtributosByProductoIdAndBodegaId(long producto, long bodega);

	List<ProductoMedidaDto> findAllMedidasByProductoId(long producto);

	List<ProductoMedidaDto> findAllMedidasByProductoIdAndBodegaId(long producto, long bodega);
}