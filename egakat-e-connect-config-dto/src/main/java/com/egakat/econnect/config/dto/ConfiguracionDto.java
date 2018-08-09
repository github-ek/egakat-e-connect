package com.egakat.econnect.config.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.commons.dto.BusinessEntityDto;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class ConfiguracionDto extends BusinessEntityDto<Long> implements ObjectWithCode<Long>, InactivableObject {

	private long idGrupoConfiguracion;

	@NotNull
	@Size(max = 50)
	private String codigo;

	@NotNull
	@Size(max = 1000)
	private String valor;

	private boolean activo;

	@Builder
	public ConfiguracionDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, long idGrupoConfiguracion, @NotNull @Size(max = 50) String codigo,
			@NotNull @Size(max = 1000) String valor, boolean activo) {
		super(id, version, fechaCreacion, creadoPor, fechaModificacion, modificadoPor);
		this.idGrupoConfiguracion = idGrupoConfiguracion;
		this.codigo = codigo;
		this.valor = valor;
		this.activo = activo;
	}
}