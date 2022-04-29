package ru.attempt.bugawa.postservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.attempt.buga.lib.PostLibConfig;

/**
 *
 */
@Slf4j
@SpringBootApplication
@Import(PostLibConfig.class)
public class PostApp {

	/**
	 * @param args
	 * 		входные параметры
	 */
	public static void main (final String[] args) {
		SpringApplication.run(PostApp.class, args);
	}
}
