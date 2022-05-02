package ru.attempt.bugawa.postservice.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.attempt.bugawa.lib.model.dto.response.PostResponse;
import ru.attempt.bugawa.postservice.model.entity.Article;

import java.util.UUID;

/**
 * DTO модель ответа. Расширяет класс {@link PostResponse}
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown=true)
@Schema(description = "Модель ответа сервиса публикации обзоров", name = "ArticleResponse")
public class ReviewResponse extends PostResponse {

	/**
	 * Ссылка на статью, на которую сделан данный обзор.
	 * */
	@Schema(implementation = ArticleResponse.class,
			description = "референс на предмет обзора.",
			example = "d60d2572-9709-4ef4-9fbc-60f8080f3751")
	private UUID articleId;
}
