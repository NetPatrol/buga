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
import ru.attempt.buga.lib.api.Api;
import ru.attempt.buga.lib.api.PostApiV1;
import ru.attempt.buga.lib.model.error.ErrorMessage;
import ru.attempt.buga.lib.service.PostService;
import ru.attempt.bugawa.postservice.model.dto.request.ReviewRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ReviewResponse;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;
import static ru.attempt.bugawa.postservice.meta.PostOpenApiTag.REVIEW_API_TAG;


/**
 * Контроллер. Реализует API интерфейс обзоров.
 */
@Slf4j
@RestController
@Tag(name = REVIEW_API_TAG)
@RequestMapping("${app.api.path}" + "${app.api.v1.post.reviews}")
public class ReviewControllerImpl implements Api, PostApiV1<ReviewRequest, String> {

	private final PostService<ReviewResponse, ReviewRequest, String> service;

	/**
	 * Конструктор
	 *
	 * @param service
	 * 		сервис обзоров
	 */
	public ReviewControllerImpl (@NonNull final PostService<ReviewResponse, ReviewRequest, String> service) {
		this.service = service;
	}

	@Operation(summary = "сохраняет в бд сущность обзорной публикации",
			responses = {
					@ApiResponse(responseCode = "200", description = "добавленная сущность обзора",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ReviewResponse.class))),
					@ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ErrorMessage.class)))
			}
	)
	@Override
	@PostMapping
	public @NonNull ResponseEntity<?> save (@NonNull final ReviewRequest request) {
		final ReviewResponse response = service.save(request);
		return ok(response);
	}

	@Operation(summary = "предоставляет набор всех имеющихся в БД обзорных публикаций",
			responses = {
					@ApiResponse(responseCode = "200", description = "массив всех обзорных публикаций",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ReviewResponse.class))),
					@ApiResponse(responseCode = "400", description = "отсутствуют записи в БД",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ErrorMessage.class)))
			}
	)
	@Override
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public @NonNull ResponseEntity<?> findAll () {
		final List<ReviewResponse> response = service.findAll();
		return response.isEmpty() ? badRequest().build() : ok(response);
	}

	@Operation(summary = "предоставляет запрошенную по ключу обзорную публикацию",
			responses = {
					@ApiResponse(responseCode = "200", description = "обзорная публикация",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ReviewResponse.class))),
					@ApiResponse(responseCode = "404", description = "отсутствуют запись в БД",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ErrorMessage.class)))
			}
	)
	@Override
	@GetMapping(params = "key", produces = APPLICATION_JSON_VALUE)
	public @NonNull ResponseEntity<?> findByKey (@NonNull final String key) {
		final List<ReviewResponse> response = service.findByKey(key);
		return ok().body(response);
	}

	@Operation(summary = "реактирует сущность обзорной публикации",
			responses = {
					@ApiResponse(responseCode = "200", description = "обновленная сущность обзорной публикации",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ReviewResponse.class))),
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
	@PutMapping
	public @NonNull ResponseEntity<?> edit (@NonNull final ReviewRequest request) {
		final ReviewResponse response = service.edit(request);
		return ok(response);
	}

	@Operation(summary = "удаляет сущность обзорной публикации в БД",
			responses = {
					@ApiResponse(responseCode = "200", description = "статус 200, если объект успешно удален",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ReviewResponse.class))),
					@ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера",
							content = @Content(
									mediaType = APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = ErrorMessage.class)))
			}
	)
	@Override
	@DeleteMapping
	public @NonNull ResponseEntity<?> delete (@NonNull final UUID id) {
		service.deleteById(id);
		return service.isExists(id) ? badRequest().build() : ok("Объект успешно удален");
	}
}
