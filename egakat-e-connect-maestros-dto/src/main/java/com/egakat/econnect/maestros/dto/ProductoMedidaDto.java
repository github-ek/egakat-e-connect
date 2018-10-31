package com.egakat.econnect.maestros.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

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
public class ProductoMedidaDto {

	private long idProducto;

	private long idBodega;

	private long idUnidadMedida;

	@NotNull
	@Size(max = 50)
	private String huellaCodigo;

	@NumberFormat
	private int nivel;

	@NumberFormat
	private int factorConversion;

	@NotNull
	private BigDecimal largo;

	@NotNull
	private BigDecimal ancho;

	@NotNull
	private BigDecimal alto;

	@NotNull
	private BigDecimal peso;

	private boolean receiveFlag;

	private boolean caseFlag;

	private boolean paletFlag;
}
