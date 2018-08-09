package com.egakat.econnect.maestros.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.egakat.commons.dto.BusinessEntityDto;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.domain.SortableObject;

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
public class CiudadDto extends BusinessEntityDto<Long> implements ObjectWithCode<Long>, SortableObject, InactivableObject {

	private long idDepartamento;

	@NotNull
	@Size(max = 20)
	private String codigo;

	@NotNull
	@Size(max = 20)
	private String codigoCentroPoblado;

	@NotNull
	@Size(max = 100)
	private String nombre;

	@NotNull
	@Size(max = 100)
	private String nombreAlterno;

	private BigDecimal cx;

	private BigDecimal cy;

	@NumberFormat
	private int ordinal;

	private boolean activo;

	@Builder
	public CiudadDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, long idDepartamento, @NotNull @Size(max = 20) String codigo,
			@NotNull @Size(max = 20) String codigoCentroPoblado, @NotNull @Size(max = 100) String nombre,
			@NotNull @Size(max = 100) String nombreAlterno, BigDecimal cx, BigDecimal cy, int ordinal, boolean activo) {
		super(id, version, fechaCreacion, creadoPor, fechaModificacion, modificadoPor);
		this.idDepartamento = idDepartamento;
		this.codigo = codigo;
		this.codigoCentroPoblado = codigoCentroPoblado;
		this.nombre = nombre;
		this.nombreAlterno = nombreAlterno;
		this.cx = cx;
		this.cy = cy;
		this.ordinal = ordinal;
		this.activo = activo;
	}
}