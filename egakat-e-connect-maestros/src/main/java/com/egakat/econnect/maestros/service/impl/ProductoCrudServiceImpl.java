package com.egakat.econnect.maestros.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Producto;
import com.egakat.econnect.maestros.domain.ProductoAtributo;
import com.egakat.econnect.maestros.domain.ProductoMedida;
import com.egakat.econnect.maestros.dto.ProductoAtributoDto;
import com.egakat.econnect.maestros.dto.ProductoCodigoDto;
import com.egakat.econnect.maestros.dto.ProductoDto;
import com.egakat.econnect.maestros.dto.ProductoMedidaDto;
import com.egakat.econnect.maestros.repository.ClienteRepository;
import com.egakat.econnect.maestros.repository.ProductoRepository;
import com.egakat.econnect.maestros.service.api.ProductoCrudService;

import lombok.val;

@Service
public class ProductoCrudServiceImpl extends CrudServiceImpl<Producto, ProductoDto, Long>
		implements ProductoCrudService {

	@Autowired
	private ProductoRepository repository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	protected ProductoRepository getRepository() {
		return repository;
	}

	@Override
	protected ProductoDto asModel(Producto entity) {
		// @formatter:off
		val result = ProductoDto
				.builder()
				.id(entity.getId())
				.idCliente(entity.getCliente().getId())
				.codigo(entity.getCodigo())
				.nombre(entity.getNombre())
				.activo(entity.isActivo())
				.version(entity.getVersion())
				.creadoPor(entity.getCreadoPor())
				.fechaCreacion(entity.getFechaCreacion())
				.modificadoPor(entity.getModificadoPor())
				.fechaModificacion(entity.getFechaModificacion())

				.build();
		// @formatter:on
		return result;
	}

	@Override
	protected Producto mergeEntity(ProductoDto model, Producto entity) {
		val cliente = clienteRepository.getOne(model.getIdCliente());

		entity.setCliente(cliente);
		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Producto newEntity() {
		return new Producto();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<ProductoDto> findOneByClienteIdAndCodigo(long cliente, String codigo) {
		val entity = getRepository().findOneByClienteIdAndCodigo(cliente, codigo);
		if (entity == null) {
			return Optional.empty();
		}
		val result = asModel(entity);
		return Optional.of(result);
	}

	@Override
	public List<ProductoDto> findAllByClienteId(long cliente) {
		val entities = getRepository().findAllByClienteId(cliente);
		val result = asModels(entities);
		return result;
	}

	protected Producto findOneById(long id) {
		val optional = getRepository().findById(id);
		if (!optional.isPresent()) {
			throw new EntityNotFoundException("id = " + id);
		}

		val entity = optional.get();
		return entity;
	}

	@Override
	public List<ProductoCodigoDto> findAllCodigosByProductoId(long id) {
		val entity = findOneById(id);
		// @formatter:off
		val result = entity.getCodigos()
				.stream()
				.map(a -> 
				ProductoCodigoDto
					.builder()
					.idProducto(id)
					.codigo(a.getCodigo())
					.tipoCodigo(a.getTipoCodigo())
					.activo(a.isActivo())
					.build())
				.collect(toList());
		// @formatter:on

		return result;
	}

	@Override
	public List<ProductoAtributoDto> findAllAtributosByProductoId(long id) {
		val entity = findOneById(id);
		// @formatter:off
		val result = entity.getAtributos()
				.stream()
				.map(a -> mapAtributoToDto(id, a))
				.collect(toList());
		// @formatter:on

		return result;
	}

	@Override
	public List<ProductoAtributoDto> findAllAtributosByProductoIdAndBodegaId(long id, long bodega) {
		val entity = findOneById(id);

		// @formatter:off
		val result = entity.getAtributos()
				.stream()
				.filter(a -> a.getIdBodega() == bodega)
				.map(a -> mapAtributoToDto(id, a))
				.collect(toList());
		// @formatter:on

		return result;
	}

	@Override
	public List<ProductoMedidaDto> findAllMedidasByProductoId(long id) {
		val entity = findOneById(id);
		
		// @formatter:off
		val result = entity.getMedidas()
				.stream()
				.map(a -> mapMedidaToDto(id, a))
				.collect(toList());
		// @formatter:on
		
		return result;
	}

	@Override
	public List<ProductoMedidaDto> findAllMedidasByProductoIdAndBodegaId(long id, long bodega) {
		val entity = findOneById(id);

		// @formatter:off
		val result = entity.getMedidas()
				.stream()
				.filter(a -> a.getIdBodega() == bodega)
				.map(a -> mapMedidaToDto(id, a))
				.collect(toList());
		// @formatter:on

		return result;
	}

	private ProductoAtributoDto mapAtributoToDto(long producto, ProductoAtributo a) {
		// @formatter:off
		val result = ProductoAtributoDto
				.builder()
				.idProducto(producto)
				.idBodega(a.getIdBodega())
				.codigo(a.getCodigo())
				.valor(a.getValor())
				.build();
		// @formatter:on

		return result;
	}

	private ProductoMedidaDto mapMedidaToDto(long producto, ProductoMedida a) {
		// @formatter:off
		val result  = ProductoMedidaDto
				.builder()
				.idProducto(producto)
				.idBodega(a.getIdBodega())
				.idUnidadMedida(a.getIdUnidadMedida())
				.huellaCodigo(a.getHuellaCodigo())
				.nivel(a.getNivel())
				.factorConversion(a.getFactorConversion())
				.largo(a.getLargo())
				.ancho(a.getAncho())
				.alto(a.getAlto())
				.peso(a.getPeso())
				.receiveFlag(a.isReceiveFlag())
				.caseFlag(a.isCaseFlag())
				.paletFlag(a.isPaletFlag())
				.build();
		// @formatter:on

		return result;
	}
}