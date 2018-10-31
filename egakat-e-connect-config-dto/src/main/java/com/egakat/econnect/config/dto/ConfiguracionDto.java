package com.egakat.econnect.config.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.dto.AuditableEntityDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class ConfiguracionDto extends AuditableEntityDto<Long> implements ObjectWithCode<Long>, InactivableObject {

	private long idGrupoConfiguracion;

	@NotNull
	@Size(max = 50)
	private String codigo;

	@NotNull
	@Size(max = 1000)
	private String valor;

	private boolean activo;
}