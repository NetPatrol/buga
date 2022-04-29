package ru.attempt.bugawa.postservice.mapper;

import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.attempt.bugawa.postservice.model.dto.request.AnnounceRequest;
import ru.attempt.bugawa.postservice.model.dto.response.AnnounceResponse;
import ru.attempt.bugawa.postservice.model.entity.Announce;

import java.util.List;

/**
 *
 */
@Mapper(componentModel = "spring")
public interface AnnounceMapper {

	/**
	 * @param request
	 *
	 * @return
	 */
	@NonNull

	@Mapping(target = "create", ignore = true)
	@Mapping(target = "lastEdit", ignore = true)
	@Mapping(target = "delete", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "like", ignore = true)
	@Mapping(target = "dislike", ignore = true)
	@Mapping(target = "count", ignore = true)
	Announce toEntity (@NonNull final AnnounceRequest request);

	/**
	 * @param announce
	 *
	 * @return
	 */
	@NonNull
	AnnounceResponse toResponse (@NonNull final Announce announce);

	/**
	 * @param announce
	 *
	 * @return
	 */
	@NonNull
	List<AnnounceResponse> toResponseList (@NonNull final List<Announce> announce);
}
