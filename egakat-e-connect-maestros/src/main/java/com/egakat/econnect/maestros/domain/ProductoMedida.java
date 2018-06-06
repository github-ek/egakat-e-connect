package com.egakat.econnect.maestros.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

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
public class ProductoMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_bodega")
	private long idBodega;

	@Column(name = "id_unidad_medida")
	private long idUnidadMedida;

	@NotNull
	@Size(max = 50)
	@Column(name = "huella_codigo")
	private String huellaCodigo;

	@NumberFormat
	@Column(name = "nivel")
	private int nivel;

	@NumberFormat
	@Column(name = "factor_conversion")
	private int factorConversion;

	@Column(name = "largo")
	private BigDecimal largo;

	@Column(name = "ancho")
	private BigDecimal ancho;

	@Column(name = "alto")
	private BigDecimal alto;

	@Column(name = "peso")
	private BigDecimal peso;

	@Column(name = "cas_flg")
	private boolean caseFlag;

	@Column(name = "pal_flg")
	private boolean paletFlag;

	@Column(name = "rcv_flg")
	private boolean receiveFlag;
}
