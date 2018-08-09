
package com.egakat.econnect.maestros.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.egakat.commons.dto.BusinessEntityDto;
import com.egakat.core.domain.InactivableObject;
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
public class SubestadoInventarioDto extends BusinessEntityDto<String> implements SortableObject, InactivableObject {

	@NotNull
	@Size(max = 100)
	private String nombre;

	@NotNull
	@Size(max = 200)
	private String descripcion;

	@NumberFormat
	private int ordinal;

	private boolean activo;

	@Builder
	public SubestadoInventarioDto(String id, int version, String creadoPor, LocalDateTime fechaCreacion,
			String modificadoPor, LocalDateTime fechaModificacion, @NotNull @Size(max = 100) String nombre,
			@NotNull @Size(max = 200) String descripcion, int ordinal, boolean activo) {
		super(id, version, fechaCreacion, creadoPor, fechaModificacion, modificadoPor);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ordinal = ordinal;
		this.activo = activo;
	}
}