package com.egakat.econnect.maestros.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.econnect.maestros.enums.IdentificacionType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clientes")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_cliente"))
public class Cliente extends AuditableEntity<Long> implements ObjectWithCode<Long>, InactivableObject {

	@Column(name = "codigo")
	@Size(max = 32)
	@NotNull
	private String codigo;

	@Column(name = "nombre")
	@Size(max = 100)
	@NotNull
	private String nombre;

	@Column(name = "tipo_identificacion", length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull
	private IdentificacionType tipoIdentificacion;

	@Column(name = "numero_identificacion")
	@Size(max = 20)
	@NotNull
	private String numeroIdentificacion;

	@Column(name = "digito_verificacion")
	@Size(max = 1)
	@NotNull
	private String digitoVerificacion;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_empresa", nullable = false)
	@NotNull
	private Empresa empresa;

	@Column(name = "codigo_alterno_wms")
	@Size(max = 32)
	@NotNull
	private String codigoAlternoWms;

	@Column(name = "habilitado_conciliacion")
	private boolean habilitadoConciliacion;

	@Column(name = "activo")
	private boolean activo;

	@ElementCollection
	@CollectionTable(name = "clientes_servicios", joinColumns = @JoinColumn(name = "id_cliente", nullable = false))
	private Set<ClienteServicio> servicios = new HashSet<>();
}