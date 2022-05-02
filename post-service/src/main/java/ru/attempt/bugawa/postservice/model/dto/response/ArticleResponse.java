package ru.attempt.bugawa.postservice.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.attempt.bugawa.lib.model.dto.response.PostResponse;
import ru.attempt.bugawa.postservice.model.entity.Review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DTO модель ответа. Расширяет класс {@link PostResponse}
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true, exclude = "reviews")
@Schema(description = "Модель ответа сервиса публикации статей", name = "ArticleResponse")
public class ArticleResponse extends PostResponse {

	/**
	 * Набор обзоров, относящихся к данной статье
	 * */
	@Schema(implementation = List.class,
			description = "набор обзорных статей.")
	List<ReviewResponse> reviews = new ArrayList<>();
}
