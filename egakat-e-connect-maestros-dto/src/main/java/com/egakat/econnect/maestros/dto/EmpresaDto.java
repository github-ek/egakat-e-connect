
package com.egakat.econnect.maestros.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.domain.SortableObject;
import com.egakat.core.dto.AuditableEntityDto;
import com.egakat.econnect.maestros.enums.IdentificacionType;

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
public class EmpresaDto extends AuditableEntityDto<Long> implements ObjectWithCode<Long>, SortableObject, InactivableObject {

	@NotNull
	@Size(max = 20)
	private String codigo;

	@NotNull
	@Size(max = 100)
	private String nombre;

	@NotNull
	private IdentificacionType tipoIdentificacion;

	@NotNull
	@Size(max = 20)
	private String numeroIdentificacion;

	@NotNull
	@Size(max = 1)
	private String digitoVerificacion;

	@NumberFormat
	private int ordinal;

	private boolean activo;
}