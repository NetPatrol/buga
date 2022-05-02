package ru.attempt.bugawa.postservice.model.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.attempt.bugawa.lib.model.dto.request.PostRequest;

/**
 * DTO модель запроса для работы с сущностью статьи.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleRequest extends PostRequest {
}
