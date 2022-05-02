package ru.attempt.bugawa.postservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.attempt.bugawa.postservice.model.dto.request.ReviewRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ReviewResponse;
import ru.attempt.bugawa.postservice.model.entity.Review;

import java.util.List;

/**
 * Маппер сущности обзора и DTO обзора
 */
@Mapper(componentModel = "spring")
public interface ReviewMapper {

	/**
	 * @param request DTO модели запроса обзора
	 *
	 * @return сущность обзора
	 */
	@Mappings(
			{
					@Mapping(target = "author", source = "author"),
					@Mapping(target = "header", source = "header"),
					@Mapping(target = "body", source = "body"),
					@Mapping(target = "create", ignore = true),
					@Mapping(target = "delete", ignore = true),
					@Mapping(target = "lastEdit", ignore = true),
					@Mapping(target = "count", ignore = true),
					@Mapping(target = "like", ignore = true),
					@Mapping(target = "dislike", ignore = true),
					@Mapping(target = "article.id", source = "articleId")
			}
	)
	Review toEntity (final ReviewRequest request);

	/**
	 * @param review сущность обзора
	 *
	 * @return DTO модели ответа
	 */
	@Mapping(target = "articleId", source = "article.id")
	ReviewResponse toResponse (final Review review);

	/**
	 * @param review массив сущностей обзоров
	 *
	 * @return массив DTO моделей ответа
	 */
	List<ReviewResponse> toResponseList (final List<Review> review);
}
