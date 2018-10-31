package com.egakat.econnect.maestros.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.core.domain.InactivableObject;
import com.egakat.core.dto.AuditableEntityDto;
import com.egakat.econnect.maestros.enums.EstadoDireccionType;
import com.egakat.econnect.maestros.enums.GeoCodificacionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDto extends AuditableEntityDto<Long> implements InactivableObject {

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
}