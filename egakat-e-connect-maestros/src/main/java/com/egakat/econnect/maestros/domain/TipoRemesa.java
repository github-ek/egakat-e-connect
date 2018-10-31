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
import org.springframework.format.annotation.NumberFormat;

import com.egakat.core.data.jpa.domain.AuditableEntity;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.domain.SortableObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tipos_remesa")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_tipo_remesa"))
public class TipoRemesa extends AuditableEntity<Long>
		implements ObjectWithCode<Long>, SortableObject, InactivableObject {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_unidad_negocio", nullable = false)
	@NotNull
	private UnidadNegocio unidadNegocio;

	@NotNull
	@Size(max = 20)
	@Column(name = "codigo")
	private String codigo;

	@NotNull
	@Size(max = 100)
	@Column(name = "nombre")
	private String nombre;

	@NotNull
	@Size(max = 200)
	@Column(name = "descripcion")
	private String descripcion;

	@NumberFormat
	@Column(name = "ordinal")
	private int ordinal;

	@Column(name = "activo")
	private boolean activo;

}
