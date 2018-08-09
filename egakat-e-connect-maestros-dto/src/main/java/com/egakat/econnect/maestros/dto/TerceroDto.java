package com.egakat.econnect.maestros.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.commons.dto.BusinessEntityDto;
import com.egakat.core.domain.InactivableObject;
import com.egakat.econnect.maestros.enums.IdentificacionType;

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
public class TerceroDto extends BusinessEntityDto<Long> implements InactivableObject {

	private long idCliente;

	@NotNull
	private IdentificacionType tipoIdentificacion;

	@NotNull
	@Size(max = 20)
	private String numeroIdentificacion;

	@NotNull
	@Size(max = 100)
	private String nombre;

	private boolean activo;

	@Builder
	public TerceroDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, long idCliente, @NotNull IdentificacionType tipoIdentificacion,
			@NotNull @Size(max = 20) String numeroIdentificacion, @NotNull @Size(max = 100) String nombre,
			boolean activo) {
		super(id, version, fechaCreacion, creadoPor, fechaModificacion, modificadoPor);
		this.idCliente = idCliente;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.activo = activo;
	}
}
