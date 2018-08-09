package com.egakat.econnect.maestros.dto;

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
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BodegaDto extends BusinessEntityDto<Long> implements ObjectWithCode<Long>, SortableObject, InactivableObject {

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

	@Builder
	public BodegaDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, @NotNull @Size(max = 20) String codigo,
			@NotNull @Size(max = 100) String nombre, Long idCiudad, @NotNull @Size(max = 150) String direccion,
			Long idDireccion, int ordinal, boolean activo) {
		super(id, version, creadoPor, fechaCreacion, modificadoPor, fechaModificacion);
		this.codigo = codigo;
		this.nombre = nombre;
		this.idCiudad = idCiudad;
		this.direccion = direccion;
		this.idDireccion = idDireccion;
		this.ordinal = ordinal;
		this.activo = activo;
	}
}
