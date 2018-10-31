package com.egakat.econnect.maestros.domain;

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

import com.egakat.core.data.jpa.domain.AuditableEntity;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "puntos")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_punto"))
public class Punto extends AuditableEntity<Long> implements ObjectWithCode<Long>, InactivableObject {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_tercero", nullable = false)
	@NotNull
	private Tercero tercero;

	@NotNull
	@Size(max = 20)
	@Column(name = "codigo")
	private String codigo;

	@NotNull
	@Size(max = 100)
	@Column(name = "nombre")
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_ciudad", nullable = false)
	@NotNull
	private Ciudad ciudad;

	@NotNull
	@Size(max = 150)
	@Column(name = "direccion")
	private String direccion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_direccion")
	private Direccion objetoDireccion;

	@Column(name = "activo")
	private boolean activo;

}