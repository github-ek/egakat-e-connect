package com.egakat.econnect.conciliaciones.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.NumberFormat;

import com.egakat.commons.domain.AuditableEntity;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.domain.SortableObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "estados_conciliacion")
@DynamicUpdate
@Getter
@Setter
@ToString(callSuper= true)
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_estado_conciliacion"))
public class EstadoConciliacion extends AuditableEntity<Long> implements ObjectWithCode<Long>, SortableObject, InactivableObject {

	@Column(name = "codigo")
	@Size(max = 20)
	@NotNull
	private String codigo;

	@Column(name = "nombre")
	@Size(max = 100)
	@NotNull
	private String nombre;

	@Column(name = "descripcion")
	@Size(max = 200)
	@NotNull
	private String descripcion;

	@Column(name = "ordinal")
	@NumberFormat
	private int ordinal;

	@Column(name = "activo")
	private boolean activo;
}