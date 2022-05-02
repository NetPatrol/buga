package ru.attempt.bugawa.postservice.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.attempt.bugawa.lib.service.PostService;
import ru.attempt.bugawa.postservice.mapper.ReviewMapper;
import ru.attempt.bugawa.postservice.model.dto.request.ReviewRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ReviewResponse;
import ru.attempt.bugawa.postservice.model.entity.Article;
import ru.attempt.bugawa.postservice.model.entity.Review;
import ru.attempt.bugawa.postservice.repository.ReviewRepository;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Сервис обзорных статей.
 * Расширяет класс {@link PostServiceImpl}, а таже реализует интерфейс {@link PostService}
 */
@Slf4j
@Service
public class ReviewServiceImpl
		extends PostServiceImpl<ReviewRepository>
		implements PostService<ReviewResponse, ReviewRequest> {

	/**
	 * Маппер.
	 * */
	private final ReviewMapper mapper;

	/**
	 * Конструктор
	 *
	 * @param repository
	 * 		репозиторий обзоров
	 * @param mapper
	 * 		маппер для конвертации объектов
	 */
	public ReviewServiceImpl (@NonNull final ReviewRepository repository, @NonNull final ReviewMapper mapper) {
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
	@Transactional
	public ReviewResponse findById (@NonNull final UUID id) {
		return mapper.toResponse(repository.getById(id));
	}

	@NonNull
	@Override
	@Transactional
	public List<ReviewResponse> findByAuthor (@NonNull final String key) {
		log.info("аргумент author " + key + " передан в метод сервиса");
		log.info("делаем запрос в БД");
		final List<Review> reviews = repository.findByAuthor(key);
		log.info("складываем все в респонс и возвращаем");
		return mapper.toResponseList(reviews);
	}

	@NonNull
	@Override
	public ReviewResponse edit (@NonNull final ReviewRequest request) {
		log.info("запрос для редактирования с id: " + request.getId() + " получен сервисом");
		final Review review = repository.getById(Objects.requireNonNull(request.getId()));
		review.setAuthor(Objects.requireNonNull(request.getAuthor()));
		review.setHeader(Objects.requireNonNull(request.getHeader()));
		review.setBody(Objects.requireNonNull(request.getBody()));
		review.setLastEdit(ZonedDateTime.now());
		final Review result = repository.save(review);
		return mapper.toResponse(result);
	}
}
