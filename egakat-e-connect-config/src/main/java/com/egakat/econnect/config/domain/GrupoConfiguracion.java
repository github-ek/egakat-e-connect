package com.egakat.econnect.config.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.NumberFormat;

import com.egakat.commons.domain.BusinessEntity;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.domain.SortableObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "grupos_configuracion")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_grupo_configuracion"))
public class GrupoConfiguracion extends BusinessEntity<Long> implements ObjectWithCode<Long>, SortableObject, InactivableObject {

	@Column(name = "codigo")
	@Size(max = 50)
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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_grupo_configuracion")
	private Set<Configuracion> configuraciones = new HashSet<>();
}
