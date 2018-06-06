package com.egakat.econnect.maestros.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Builder
public class ProductoCodigoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idProducto;

	@NotNull
	@Size(max = 50)
	private String codigo;

	@NotNull
	@Size(max = 50)
	private String tipoCodigo;
	
	private boolean activo;
}
