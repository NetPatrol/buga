package ru.attempt.bugawa.postservice.model.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.attempt.bugawa.lib.model.dto.request.PostRequest;

import java.util.UUID;

/**
 * DTO модель запроса для работы с сущностью обзорной статьи.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewRequest extends PostRequest {

	/**
	 * Ссылка на статью на которую написан обзор
	 * */
	@JsonProperty("article_id")
	private UUID articleId;
}
