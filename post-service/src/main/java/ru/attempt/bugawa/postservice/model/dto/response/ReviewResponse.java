package ru.attempt.bugawa.postservice.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.attempt.buga.lib.model.dto.response.PostResponse;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Модель ответа сервиса публикации обзоров", name = "ArticleResponse")
public class ReviewResponse extends PostResponse {
}
