package ru.attempt.bugawa.postservice.mapper;

import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.attempt.bugawa.postservice.model.dto.request.ReviewRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ReviewResponse;
import ru.attempt.bugawa.postservice.model.entity.Review;

import java.util.List;

/**
 *
 */
@Mapper(componentModel = "spring")
public interface ReviewMapper {

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
	@Mapping(target = "article", ignore = true)
	@Mapping(target = "count", ignore = true)
	Review toEntity (@NonNull ReviewRequest request);

	/**
	 * @param article
	 *
	 * @return
	 */
	ReviewResponse toResponse (Review article);

	/**
	 * @param articles
	 *
	 * @return
	 */
	@NonNull List<ReviewResponse> toResponseList (List<Review> articles);
}
