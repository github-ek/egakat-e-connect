package com.egakat.econnect.config.domain;

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

import com.egakat.commons.domain.BusinessEntity;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "configuraciones")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_configuracion"))
public class Configuracion extends BusinessEntity<Long> implements ObjectWithCode<Long>, InactivableObject {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_grupo_configuracion", nullable = false)
	@NotNull
	private GrupoConfiguracion grupoConfiguracion;

	@Column(name = "codigo")
	@Size(max = 50)
	@NotNull
	private String codigo;

	@Column(name = "valor")
	@Size(max = 1000)
	@NotNull
	private String valor;

	@Column(name = "activo")
	private boolean activo;
}