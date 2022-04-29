package ru.attempt.bugawa.postservice.config;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
	/**
	 * Метод позволяет избежать проблем с возвратом исключений в ResponseEntity.
	 */
	@Override
	public void configureContentNegotiation (@NonNull final ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true);
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
}
