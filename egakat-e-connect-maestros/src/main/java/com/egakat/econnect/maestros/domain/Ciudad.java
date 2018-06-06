package com.egakat.econnect.maestros.domain;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.NumberFormat;

import com.egakat.commons.domain.BaseEntity;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.domain.SortableObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ciudades")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_ciudad"))
public class Ciudad extends BaseEntity<Long> implements ObjectWithCode<Long>, SortableObject, InactivableObject {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_departamento",nullable = false)
	@NotNull
	private Departamento departamento;

	@NotNull
	@Size(max = 20)
	@Column(name = "codigo")
	private String codigo;

	@NotNull
	@Size(max = 20)
	@Column(name = "codigo_centro_poblado")
	private String codigoCentroPoblado;

	@NotNull
	@Size(max = 100)
	@Column(name = "nombre")
	private String nombre;

	@NotNull
	@Size(max = 100)
	@Column(name = "nombre_alterno")
	private String nombreAlterno;

	@Column(name = "cx")
	private BigDecimal cx;

	@Column(name = "cy")
	private BigDecimal cy;

	@NumberFormat
	@Column(name = "ordinal")
	private int ordinal;

	@Column(name = "activo")
	private boolean activo;

}