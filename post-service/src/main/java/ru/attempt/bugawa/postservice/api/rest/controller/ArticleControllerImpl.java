package ru.attempt.bugawa.postservice.api.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.attempt.bugawa.lib.api.PostApiV1;
import ru.attempt.bugawa.lib.model.error.ErrorMessage;
import ru.attempt.bugawa.lib.service.PostService;
import ru.attempt.bugawa.postservice.model.dto.request.ArticleRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ArticleResponse;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;
import static ru.attempt.bugawa.postservice.meta.PostOpenApiTag.ARTICLE_API_TAG;

/**
 * Контроллер. Реализует общий API интерфейс параметризованный типом модели запроса статьи.
 */
@Slf4j
@RestController
@Tag(name = ARTICLE_API_TAG)
@RequestMapping("${app.api.path}" + "${app.api.v1.post.articles}")
public class ArticleControllerImpl implements PostApiV1<ArticleRequest> {

	private final PostService<ArticleResponse, ArticleRequest> service;

	/**
	 * Конструктор
	 *
	 * @param service
	 * 		сервис статей
	 */
	public ArticleControllerImpl (@NonNull final PostService<ArticleResponse, ArticleRequest> service) {
		this.service = service;
	}

	@Operation(summary = "сохраняет в бд сущность публикации статьи",
			responses = {
					@ApiResponse(responseCode = "200", description = "добавленная сущность публикации статьи",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ArticleResponse.class))),
					@ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ErrorMessage.class)))
			}
	)
	@Override
	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public @NonNull ResponseEntity<?> save (@NonNull final ArticleRequest request) {
		log.info("передача запроса в сервис и получение ответа");
		final ArticleResponse response = service.save(request);
		log.info("запрос на сохранение успешно выполнен");
		return ok(response);
	}

	@Operation(summary = "предоставляет запрошенную по ключу публикацию статьи",
			responses = {
					@ApiResponse(responseCode = "200", description = "обзорная публикация",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ArticleResponse.class))),
					@ApiResponse(responseCode = "404", description = "отсутствуют запись в БД",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ErrorMessage.class)))
			}
	)
	@Override
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public @NonNull ResponseEntity<?> findByAuthor (@NonNull final String key) {
		log.info("выполняется поиск по автору: " + key);
		final List<ArticleResponse> response = service.findByAuthor(key);
		return ok().body(response);
	}

	@Operation(summary = "реактирует сущность публикации статьи",
			responses = {
					@ApiResponse(responseCode = "200", description = "обновленная сущность публикации статьи",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ArticleResponse.class))),
					@ApiResponse(responseCode = "400",
							description = "не верно сформирован запрос или незаполнены обязательные поля",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ErrorMessage.class))),
					@ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ErrorMessage.class)))
			}
	)
	@Override
	@PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public @NonNull ResponseEntity<?> edit (@NonNull final ArticleRequest request) {
		log.info("передача запроса в сервис и получение ответа");
		final ArticleResponse response = service.edit(request);
		log.info("запрос на редактирование успешно выполнен");
		return ok(response);
	}

	@Operation(summary = "удаляет сущность публикации статьи в БД",
			responses = {
					@ApiResponse(responseCode = "200", description = "статус 200, если объект успешно удален",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ArticleResponse.class))),
					@ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ErrorMessage.class)))
			}
	)
	@Override
	@DeleteMapping(produces = APPLICATION_JSON_VALUE)
	public @NonNull ResponseEntity<?> delete (@NonNull final UUID id) {
		log.info("передача запроса в сервис и получение ответа");
		service.deleteById(id);
		return service.isExists(id) ? badRequest().build() : ok("Объект успешно удален");
	}
}
