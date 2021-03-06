package com.egakat.econnect.maestros.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.domain.SortableObject;
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
public class BodegaDto extends AuditableEntityDto<Long> implements ObjectWithCode<Long>, SortableObject, InactivableObject {

	@NotNull
	@Size(max = 20)
	private String codigo;

	@NotNull
	@Size(max = 100)
	private String nombre;

	private Long idCiudad;

	@NotNull
	@Size(max = 150)
	private String direccion;

	private Long idDireccion;

	@NumberFormat
	private int ordinal;

	private boolean activo;
}
