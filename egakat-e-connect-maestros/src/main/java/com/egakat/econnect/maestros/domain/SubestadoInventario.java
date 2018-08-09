package com.egakat.econnect.maestros.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.egakat.core.domain.IdentifiedDomainObject;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectAuditableByUser;
import com.egakat.core.domain.SortableObject;
import com.egakat.core.domain.VersionableObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "subestados_inventario")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SubestadoInventario implements IdentifiedDomainObject<String>, SortableObject, InactivableObject,
		VersionableObject, ObjectAuditableByUser {

	@Id
	@NotEmpty
	@Size(max = 25)
	@Column(name = "id_subestado_inventario")
	private String id;

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

	@Version
	private int version;

	@Column(name = "fecha_creacion", updatable = false)
	@CreatedDate
	@DateTimeFormat(style = "M-")
	private LocalDateTime fechaCreacion;

	@Column(name = "usuario_creacion", updatable = false)
	@CreatedBy
	private String creadoPor;

	@Column(name = "fecha_modificacion")
	@LastModifiedDate
	@DateTimeFormat(style = "M-")
	private LocalDateTime fechaModificacion;

	@Column(name = "usuario_modificacion")
	@LastModifiedBy
	private String modificadoPor;
}
