package com.egakat.econnect.maestros.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.egakat.commons.domain.AuditableEntity;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "productos")
@DynamicUpdate
@Getter
@Setter
@ToString(exclude = { "codigos", "atributos", "medidas" })
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_producto"))
public class Producto extends AuditableEntity<Long> implements ObjectWithCode<Long>, InactivableObject {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cliente", nullable = false)
	@NotNull
	private Cliente cliente;

	@NotNull
	@Size(max = 50)
	@Column(name = "codigo")
	private String codigo;

	@NotNull
	@Size(max = 250)
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "activo")
	private boolean activo;

	@ElementCollection
	@CollectionTable(name = "productos_codigos", joinColumns = @JoinColumn(name = "id_producto", nullable = false))
	private Set<ProductoCodigo> codigos = new HashSet<>();

	@ElementCollection
	@CollectionTable(name = "productos_atributos", joinColumns = @JoinColumn(name = "id_producto", nullable = false))
	private Set<ProductoAtributo> atributos = new HashSet<>();

	@ElementCollection
	@CollectionTable(name = "productos_medidas", joinColumns = @JoinColumn(name = "id_producto", nullable = false))
	private Set<ProductoMedida> medidas = new HashSet<>();
}