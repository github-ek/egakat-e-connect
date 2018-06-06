package com.egakat.econnect.maestros.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.commons.dto.EntityDto;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
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
public class ClienteDto extends EntityDto<Long> implements ObjectWithCode<Long> ,InactivableObject {

	private static final long serialVersionUID = 1L;

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

	private long idEmpresa;

	@NotNull
	@Size(max = 100)
	private String codigoAlternoWms;

	private boolean habilitadoConciliacion;
	
	private boolean activo;

	@Builder
	public ClienteDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, @NotNull @Size(max = 20) String codigo,
			@NotNull @Size(max = 100) String nombre, @NotNull IdentificacionType tipoIdentificacion,
			@NotNull @Size(max = 20) String numeroIdentificacion, @NotNull @Size(max = 1) String digitoVerificacion,
			long idEmpresa, @NotNull @Size(max = 100) String codigoAlternoWms, boolean habilitadoConciliacion,
			boolean activo) {
		super(id, version, creadoPor, fechaCreacion, modificadoPor, fechaModificacion);
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.digitoVerificacion = digitoVerificacion;
		this.idEmpresa = idEmpresa;
		this.codigoAlternoWms = codigoAlternoWms;
		this.habilitadoConciliacion = habilitadoConciliacion;
		this.activo = activo;
	}
}
