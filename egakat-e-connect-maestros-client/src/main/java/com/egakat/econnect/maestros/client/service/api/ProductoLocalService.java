package com.egakat.econnect.maestros.client.service.api;

import java.util.List;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.maestros.dto.ProductoAtributoDto;
import com.egakat.econnect.maestros.dto.ProductoCodigoDto;
import com.egakat.econnect.maestros.dto.ProductoDto;
import com.egakat.econnect.maestros.dto.ProductoMedidaDto;

public interface ProductoLocalService extends LocalQueryService<ProductoDto, Long> {

	List<ProductoCodigoDto> getCodigosByProductoId(long producto);

	List<ProductoAtributoDto> getAtributosByProductoId(long producto);

	List<ProductoAtributoDto> getAtributosByProductoIdAndBodegaId(long producto, long bodega);

	List<ProductoMedidaDto> getMedidasByProductoId(long producto);

	List<ProductoMedidaDto> getMedidasByProductoIdAndBodegaId(long producto, long bodega);
}
