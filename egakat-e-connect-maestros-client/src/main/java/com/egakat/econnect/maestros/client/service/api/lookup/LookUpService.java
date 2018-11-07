package com.egakat.econnect.maestros.client.service.api.lookup;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.egakat.core.web.client.service.api.CacheEvictSupported;

public interface LookUpService extends CacheEvictSupported {

	@Cacheable(cacheNames = "clienteId-by-codigo", unless = "#result == null")
	Long findClienteIdByCodigo(String codigo);

	@Cacheable(cacheNames = "clienteId-by-numeroIdentificacion", unless = "#result == null")
	Long findClienteIdByNumeroIndentificacion(String numeroIdentificacion);

	@Cacheable(cacheNames = "clienteId-by-codigoWms", unless = "#result == null")
	Long findClienteIdByCodigoWms(String codigo);

	@Cacheable(cacheNames = "servicioId-by-codigo", unless = "#result == null")
	Long findServicioIdByCodigo(String codigo);

	@Cacheable(cacheNames = "canalId-by-codigo", unless = "#result == null")
	Long findCanalIdByCodigo(String codigo);

	@Cacheable(cacheNames = "tercerId-by-numeroIdentificacion")
	Long findTerceroIdByIdAndNumeroIdentificacion(long cliente, String numeroIdentificacion);

	@Cacheable(cacheNames = "puntoId-by-codigo")
	Long findPuntoIdByTerceroIdAndPuntoCodigo(long tercero, String codigo);

	@Cacheable(cacheNames = "ciudadId-by-codigo", unless = "#result == null")
	Long findCiudadIdByCodigo(String codigo);

	@Cacheable(cacheNames = "ciudadId-by-nombreAlterno", unless = "#result == null")
	Long findCiudadIdByNombreAlterno(String nombreAlterno);

	@Cacheable(cacheNames = "productoId-by-cliente-and-codigo", unless = "#result == null")
	Long findProductoIdByClienteIdAndCodigo(long cliente, String codigo);

	@Cacheable(cacheNames = "unidadMedidaId-de-recibo-by-producto-and-bodega", unless = "#result == null")
	Long findUnidadMedidaDeReciboIdByProductoIdAndBodegaId(long producto, long bodega);

	@Cacheable(cacheNames = "unidadMedidaId-by-codigo", unless = "#result == null")
	Long findUnidadMedidaIdByCodigo(String codigo);

	@Cacheable(cacheNames = "bodegaId-by-codigo", unless = "#result == null")
	Long findBodegaIdByCodigo(String codigo);

	@Cacheable(cacheNames = "estadosInventarioId-by-codigo", unless = "#result == null")
	String findEstadoInventarioIdByCodigo(String codigo);

	@Cacheable(cacheNames = "subestadosInventarioId-by-codigo", unless = "#result == null")
	String findSubestadoInventarioIdByCodigo(String codigo);

	@CacheEvict(cacheNames = { "clienteId-by-codigo", "clienteId-by-numeroIdentificacion", "clienteId-by-codigoWms",
			"servicioId-by-codigo", "canalId-by-codigo", "tercerId-by-numeroIdentificacion", "puntoId-by-codigo",
			"ciudadId-by-codigo", "ciudadId-by-nombreAlterno", "productoId-by-cliente-and-codigo",
			"unidadMedidaId-de-recibo-by-producto-and-bodega", "unidadMedidaId-by-codigo", "bodegaId-by-codigo",
			"estadosInventarioId-by-codigo", "subestadosInventarioId-by-codigo" }, allEntries = true)
	void cacheEvict();
}