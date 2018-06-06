package com.egakat.econnect.maestros.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.core.domain.InactivableObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoCodigo implements Serializable, InactivableObject {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(max = 50)
	@Column(name = "codigo")
	private String codigo;

	@NotNull
	@Size(max = 50)
	@Column(name = "tipo_codigo")
	private String tipoCodigo;

	@Column(name = "activo")
	private boolean activo;
}
