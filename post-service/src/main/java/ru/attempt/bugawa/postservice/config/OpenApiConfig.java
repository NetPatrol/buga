package ru.attempt.bugawa.postservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

/**
 *
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "openapi")
public class OpenApiConfig {

	@NotNull
	private String title;

	@NotNull
	private String description;

	@NotNull
	private String docs;

	@NotNull
	private String docsUrl;


}
