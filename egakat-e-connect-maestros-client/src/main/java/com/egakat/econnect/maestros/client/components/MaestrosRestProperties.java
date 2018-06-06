package com.egakat.econnect.maestros.client.components;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.egakat.core.web.client.configuration.RestProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix = "com.egakat.econnect.maestros.rest")
@Getter
@Setter
@ToString
@Validated
public class MaestrosRestProperties implements RestProperties {

	private String basePath;
}

