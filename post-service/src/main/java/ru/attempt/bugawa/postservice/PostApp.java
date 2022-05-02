package ru.attempt.bugawa.postservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.attempt.bugawa.lib.PostLibConfig;

/**
 * Стартовый класс приложения.
 */
@Slf4j
@SpringBootApplication
@Import(PostLibConfig.class)
@EnableJpaRepositories("ru.attempt.bugawa.postservice.repository")
public class PostApp {

	/**
	 * @param args
	 * 		входные аргументы (не используются)
	 */
	public static void main (final String[] args) {
		SpringApplication.run(PostApp.class, args);
	}
}
