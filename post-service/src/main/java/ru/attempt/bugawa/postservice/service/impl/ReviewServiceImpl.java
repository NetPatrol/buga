package ru.attempt.bugawa.postservice.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.attempt.buga.lib.repository.PostRepository;
import ru.attempt.buga.lib.service.PostServiceImpl;
import ru.attempt.bugawa.postservice.mapper.ReviewMapper;
import ru.attempt.bugawa.postservice.model.dto.request.ReviewRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ReviewResponse;
import ru.attempt.bugawa.postservice.model.entity.Review;

import java.util.List;
import java.util.Objects;

/**
 *
 */
@Slf4j
@Service
public class ReviewServiceImpl extends PostServiceImpl<Review, ReviewResponse, ReviewRequest, String> {

	private final ReviewMapper mapper;

	/**
	 * Конструктор
	 *
	 * @param repository
	 * 		репозиторий обзоров
	 * @param mapper
	 * 		маппер для конвертации объектов
	 */
	public ReviewServiceImpl (@NonNull final PostRepository<Review> repository,
	                          @NonNull final ReviewMapper mapper) {
		super(repository);
		this.mapper = mapper;
	}

	@NonNull
	@Override
	public ReviewResponse save (@NonNull final ReviewRequest request) {
		final Review review = mapper.toEntity(request);
		return mapper.toResponse(repository.save(review));
	}

	@NonNull
	@Override
	public List<ReviewResponse> findAll () {
		return mapper.toResponseList(repository.findAll());
	}

	@NonNull
	@Override
	public List<ReviewResponse> findByKey (@NonNull final String key) {
		final List<Review> reviews = repository.findById(key).stream().toList();
		return mapper.toResponseList(reviews);
	}

	@NonNull
	@Override
	public ReviewResponse edit (@NonNull final ReviewRequest request) {
		final Review review = repository.getById(Objects.requireNonNull(request.getId()));
		final Review result = repository.save(review);
		return mapper.toResponse(result);
	}
}
