package com.egakat.econnect.conciliaciones.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import com.egakat.core.web.client.properties.RestProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ConfigurationProperties(prefix = ConciliacionesRestProperties.CONFIGURATION_PROPERTIES)
@Getter
@Setter
@ToString
@Validated
public class ConciliacionesRestProperties implements RestProperties {

	static final String CONFIGURATION_PROPERTIES = "endpoint.econnect.conciliaciones.rest";
	
	private String basePath;
	
}
