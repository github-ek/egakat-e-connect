package com.egakat.econnect.maestros.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.egakat.commons.dto.EntityDto;
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
public class PaisDto extends EntityDto<Long> implements ObjectWithCode<Long>, SortableObject, InactivableObject {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(max = 20)
	private String codigo;

	@NotNull
	@Size(max = 100)
	private String nombre;

	private BigDecimal cx;

	private BigDecimal cy;

	@NumberFormat
	private int ordinal;

	private boolean activo;

	@Builder
	public PaisDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, @NotNull @Size(max = 20) String codigo,
			@NotNull @Size(max = 100) String nombre, BigDecimal cx, BigDecimal cy, int ordinal, boolean activo) {
		super(id, version, creadoPor, fechaCreacion, modificadoPor, fechaModificacion);
		this.codigo = codigo;
		this.nombre = nombre;
		this.cx = cx;
		this.cy = cy;
		this.ordinal = ordinal;
		this.activo = activo;
	}
}