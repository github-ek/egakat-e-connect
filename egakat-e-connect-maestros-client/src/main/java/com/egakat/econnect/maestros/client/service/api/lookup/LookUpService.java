package com.egakat.econnect.maestros.client.service.api.lookup;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.egakat.core.web.client.service.api.CacheEvictSupported;

public interface LookUpService extends CacheEvictSupported {

	@Cacheable(cacheNames = "clienteId-by-codigo", sync = true)
	Long findClienteIdByCodigo(String codigo);

	@Cacheable(cacheNames = "clienteId-by-numeroIdentificacion", sync = true)
	Long findClienteIdByNumeroIndentificacion(String numeroIdentificacion);

	@Cacheable(cacheNames = "clienteId-by-codigoWms", sync = true)
	Long findClienteIdByCodigoWms(String codigo);

	@Cacheable(cacheNames = "servicioId-by-codigo", sync = true)
	Long findServicioIdByCodigo(String codigo);

	@Cacheable(cacheNames = "canalId-by-codigo", sync = true)
	Long findCanalIdByCodigo(String codigo);

	@Cacheable(cacheNames = "tercerId-by-numeroIdentificacion", sync = true)
	Long findTerceroIdByIdAndNumeroIdentificacion(long cliente, String numeroIdentificacion);

	@Cacheable(cacheNames = "puntoId-by-codigo", sync = true)
	Long findPuntoIdByTerceroIdAndPuntoCodigo(long tercero, String codigo);

	@Cacheable(cacheNames = "ciudadId-by-codigo", sync = true)
	Long findCiudadIdByCodigo(String codigo);

	@Cacheable(cacheNames = "ciudadId-by-nombreAlterno", sync = true)
	Long findCiudadIdByNombreAlterno(String nombreAlterno);

	@Cacheable(cacheNames = "productoId-by-cliente-and-codigo", sync = true)
	Long findProductoIdByClienteIdAndCodigo(long cliente, String codigo);

	@Cacheable(cacheNames = "unidadMedidaId-de-recibo-by-producto-and-bodega", sync = true)
	Long findUnidadMedidaDeReciboIdByProductoIdAndBodegaId(long producto, long bodega);

	@Cacheable(cacheNames = "unidadMedidaId-by-codigo", sync = true)
	Long findUnidadMedidaIdByCodigo(String codigo);

	@Cacheable(cacheNames = "bodegaId-by-codigo", sync = true)
	Long findBodegaIdByCodigo(String codigo);

	@Cacheable(cacheNames = "estadosInventarioId-by-codigo", sync = true)
	String findEstadoInventarioIdByCodigo(String codigo);

	@Cacheable(cacheNames = "subestadosInventarioId-by-codigo", sync = true)
	String findSubestadoInventarioIdByCodigo(String codigo);

	@CacheEvict(cacheNames = { "clienteId-by-codigo", "clienteId-by-numeroIdentificacion", "clienteId-by-codigoWms",
			"servicioId-by-codigo", "canalId-by-codigo", "tercerId-by-numeroIdentificacion", "puntoId-by-codigo",
			"ciudadId-by-codigo", "ciudadId-by-nombreAlterno", "productoId-by-cliente-and-codigo",
			"unidadMedidaId-de-recibo-by-producto-and-bodega", "unidadMedidaId-by-codigo", "bodegaId-by-codigo",
			"estadosInventarioId-by-codigo", "subestadosInventarioId-by-codigo" }, allEntries = true)
	void cacheEvict();
}