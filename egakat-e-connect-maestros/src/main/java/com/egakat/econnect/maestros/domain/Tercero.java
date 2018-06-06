package com.egakat.econnect.maestros.domain;

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

import com.egakat.commons.domain.BaseEntity;
import com.egakat.core.domain.InactivableObject;
import com.egakat.econnect.maestros.enums.IdentificacionType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "terceros")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_tercero"))
public class Tercero extends BaseEntity<Long> implements InactivableObject {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cliente", nullable = false)
	@NotNull
	private Cliente cliente;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_identificacion", length = 20)
	private IdentificacionType tipoIdentificacion;

	@NotNull
	@Size(max = 20)
	@Column(name = "numero_identificacion")
	private String numeroIdentificacion;

	@NotNull
	@Size(max = 100)
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "activo")
	private boolean activo;

}