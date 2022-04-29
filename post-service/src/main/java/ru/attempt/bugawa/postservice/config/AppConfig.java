package ru.attempt.bugawa.postservice.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.net.URI;

/**
 *
 */
@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public class AppConfig {

	@NotNull
	private Api api;

	/**
	 * Кофигурация Api.
	 */
	@Getter
	@Setter
	@Validated
	@NoArgsConstructor
	public static class Api {

		@NotNull
		private URI path;

		@NotNull
		private V1 v1;

		/**
		 * Конфигурация ресурсов API приложения.
		 */
		@Getter
		@Setter
		@Validated
		@NoArgsConstructor
		static class V1 {
			/**
			 * Ресурс публикаций.
			 */
			@NotNull
			private Post post;

			@Getter
			@Setter
			@Validated
			@NoArgsConstructor
			static class Post {

				/**
				 * Ресурс статей сервиса публикаций.
				 */
				@NotNull
				private URI articles;

				/**
				 * Ресурс анонсов сервиса публикаций.
				 */
				@NotNull
				private URI announces;

				/**
				 * Ресурс обзоров сервиса публикаций.
				 */
				@NotNull
				private URI reviews;

			}
		}
	}

}
