package com.egakat.econnect.maestros.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.commons.dto.BusinessEntityDto;
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
@ToString(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class PuntoDto extends BusinessEntityDto<Long> implements ObjectWithCode<Long>, InactivableObject {

	private long idTercero;

	@NotNull
	@Size(max = 20)
	private String codigo;

	@NotNull
	@Size(max = 100)
	private String nombre;

	private long idCiudad;

	@NotNull
	@Size(max = 150)
	private String direccion;

	private Long idDireccion;

	private boolean activo;

	@Builder
	public PuntoDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, long idTercero, @NotNull @Size(max = 20) String codigo,
			@NotNull @Size(max = 100) String nombre, long idCiudad, @NotNull @Size(max = 150) String direccion,
			Long idDireccion, boolean activo) {
		super(id, version, fechaCreacion, creadoPor, fechaModificacion, modificadoPor);
		this.idTercero = idTercero;
		this.codigo = codigo;
		this.nombre = nombre;
		this.idCiudad = idCiudad;
		this.direccion = direccion;
		this.idDireccion = idDireccion;
		this.activo = activo;
	}
}
