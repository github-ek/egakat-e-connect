package com.egakat.econnect.maestros.domain;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.egakat.commons.domain.AuditableEntity;
import com.egakat.core.domain.InactivableObject;
import com.egakat.econnect.maestros.enums.EstadoDireccionType;
import com.egakat.econnect.maestros.enums.GeoCodificacionType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "direcciones")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_direccion"))
public class Direccion extends AuditableEntity<Long> implements InactivableObject {

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 50)
	private EstadoDireccionType estado;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cliente", nullable = false)
	@NotNull
	private Cliente cliente;

	@NotNull
	@Size(max = 20)
	@Column(name = "tercero_codigo_alterno")
	private String terceroCodigoAlterno;

	@NotNull
	@Size(max = 100)
	@Column(name = "tercero_nombre")
	private String terceroNombre;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_geocodificacion", length = 50)
	private GeoCodificacionType tipoGeoCodificacion;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_ciudad", nullable = false)
	@NotNull
	private Ciudad ciudad;

	@NotNull
	@Size(max = 150)
	@Column(name = "direccion")
	private String direccion;

	@NotNull
	@Size(max = 150)
	@Column(name = "direccion_estandarizada")
	private String direccionEstandarizada;

	@Column(name = "cx")
	private BigDecimal cx;

	@Column(name = "cy")
	private BigDecimal cy;

	@NotNull
	@Size(max = 100)
	@Column(name = "zona")
	private String zona;

	@NotNull
	@Size(max = 100)
	@Column(name = "localidad")
	private String localidad;

	@NotNull
	@Size(max = 100)
	@Column(name = "barrio")
	private String barrio;

	@Column(name = "activo")
	private boolean activo;
}