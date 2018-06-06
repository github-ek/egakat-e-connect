package com.egakat.econnect.maestros.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteServicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_servicio")
	private long idServicio;

}
