package com.egakat.econnect.maestros.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.commons.dto.BusinessEntityDto;
import com.egakat.core.domain.InactivableObject;
import com.egakat.econnect.maestros.enums.EstadoDireccionType;
import com.egakat.econnect.maestros.enums.GeoCodificacionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDto extends BusinessEntityDto<Long> implements InactivableObject {

	@NotNull
	private EstadoDireccionType estado;

	private long idCliente;

	@NotNull
	@Size(max = 20)
	private String terceroCodigoAlterno;

	@NotNull
	@Size(max = 100)
	private String terceroNombre;

	@NotNull
	private GeoCodificacionType tipoGeoCodificacion;

	private long idCiudad;

	@NotNull
	@Size(max = 150)
	private String direccion;

	@NotNull
	@Size(max = 150)
	private String direccionEstandarizada;

	private BigDecimal cx;

	private BigDecimal cy;

	@NotNull
	@Size(max = 100)
	private String zona;

	@NotNull
	@Size(max = 100)
	private String localidad;

	@NotNull
	@Size(max = 100)
	private String barrio;

	private boolean activo;

	@Builder
	public DireccionDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, @NotNull EstadoDireccionType estado, long idCliente,
			@NotNull @Size(max = 20) String terceroCodigoAlterno, @NotNull @Size(max = 100) String terceroNombre,
			@NotNull GeoCodificacionType tipoGeoCodificacion, long idCiudad, @NotNull @Size(max = 150) String direccion,
			@NotNull @Size(max = 150) String direccionEstandarizada, BigDecimal cx, BigDecimal cy,
			@NotNull @Size(max = 100) String zona, @NotNull @Size(max = 100) String localidad,
			@NotNull @Size(max = 100) String barrio, boolean activo) {
		super(id, version, creadoPor, fechaCreacion, modificadoPor, fechaModificacion);
		this.estado = estado;
		this.idCliente = idCliente;
		this.terceroCodigoAlterno = terceroCodigoAlterno;
		this.terceroNombre = terceroNombre;
		this.tipoGeoCodificacion = tipoGeoCodificacion;
		this.idCiudad = idCiudad;
		this.direccion = direccion;
		this.direccionEstandarizada = direccionEstandarizada;
		this.cx = cx;
		this.cy = cy;
		this.zona = zona;
		this.localidad = localidad;
		this.barrio = barrio;
		this.activo = activo;
	}
}