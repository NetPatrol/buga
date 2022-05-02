package ru.attempt.bugawa.postservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.attempt.bugawa.postservice.model.dto.request.ArticleRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ArticleResponse;
import ru.attempt.bugawa.postservice.model.entity.Article;

import java.util.List;

/**
 * Маппер сущности статьи и DTO статьи
 */
@Mapper(componentModel = "spring", uses = ReviewMapper.class)
public interface ArticleMapper {

	/**
	 * @param request DTO модели запроса статьи
	 *
	 * @return сущность статьи
	 */
	@Mappings(
			{
					@Mapping(target = "author", source = "author"),
					@Mapping(target = "header", source = "header"),
					@Mapping(target = "body", source = "body")
			}
	)
	Article toEntity (final ArticleRequest request);

	/**
	 * @param article сущность анонса
	 *
	 * @return DTO модели ответа
	 */
	ArticleResponse toResponse (final Article article);

	/**
	 * @param articles массив сущностей анонсов
	 *
	 * @return массив DTO моделей ответа
	 */
	List<ArticleResponse> toResponseList (final List<Article> articles);

}
