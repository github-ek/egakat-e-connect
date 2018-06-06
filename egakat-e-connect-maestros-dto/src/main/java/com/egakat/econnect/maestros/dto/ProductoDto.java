package com.egakat.econnect.maestros.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.commons.dto.EntityDto;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto extends EntityDto<Long> implements ObjectWithCode<Long>, InactivableObject {

	private static final long serialVersionUID = 1L;

	private long idCliente;

	@NotNull
	@Size(max = 50)
	private String codigo;

	@NotNull
	@Size(max = 250)
	private String nombre;

	@NotNull
	@Size(max = 50)
	private String tipoCobro;

	private boolean activo;

	@Builder
	public ProductoDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, long idCliente, @NotNull @Size(max = 50) String codigo,
			@NotNull @Size(max = 250) String nombre, @NotNull @Size(max = 50) String tipoCobro, boolean activo) {
		super(id, version, creadoPor, fechaCreacion, modificadoPor, fechaModificacion);
		this.idCliente = idCliente;
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoCobro = tipoCobro;
		this.activo = activo;
	}
}
