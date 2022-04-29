package ru.attempt.bugawa.postservice.mapper;

import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.attempt.bugawa.postservice.model.dto.request.ArticleRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ArticleResponse;
import ru.attempt.bugawa.postservice.model.entity.Article;

import java.util.List;

/**
 *
 */
@Mapper(componentModel = "spring")
public interface ArticleMapper {
	/**
	 * @param request
	 *
	 * @return
	 */
	@Mapping(target = "create", ignore = true)
	@Mapping(target = "lastEdit", ignore = true)
	@Mapping(target = "delete", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "like", ignore = true)
	@Mapping(target = "dislike", ignore = true)
	@Mapping(target = "reviews", ignore = true)
	@Mapping(target = "count", ignore = true)
	Article toEntity (@NonNull ArticleRequest request);

	/**
	 * @param article
	 *
	 * @return
	 */
	ArticleResponse toResponse (Article article);

	/**
	 * @param articles
	 *
	 * @return
	 */
	@NonNull List<ArticleResponse> toResponseList (List<Article> articles);

}
