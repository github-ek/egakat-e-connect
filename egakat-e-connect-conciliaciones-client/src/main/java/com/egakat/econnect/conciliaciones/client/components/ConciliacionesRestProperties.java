package com.egakat.econnect.conciliaciones.client.components;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.egakat.core.web.client.configuration.RestProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix = "com.egakat.econnect.econciliaciones.rest")
@Getter
@Setter
@ToString
@Validated
public class ConciliacionesRestProperties implements RestProperties {

	private String basePath;
}

