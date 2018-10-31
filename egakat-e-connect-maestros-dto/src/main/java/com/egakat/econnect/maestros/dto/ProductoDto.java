package com.egakat.econnect.maestros.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.dto.AuditableEntityDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto extends AuditableEntityDto<Long> implements ObjectWithCode<Long>, InactivableObject {

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
}
