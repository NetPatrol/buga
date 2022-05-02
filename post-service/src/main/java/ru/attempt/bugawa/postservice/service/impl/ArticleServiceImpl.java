package ru.attempt.bugawa.postservice.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.attempt.bugawa.lib.service.PostService;
import ru.attempt.bugawa.postservice.mapper.ArticleMapper;
import ru.attempt.bugawa.postservice.model.dto.request.ArticleRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ArticleResponse;
import ru.attempt.bugawa.postservice.model.entity.Article;
import ru.attempt.bugawa.postservice.repository.ArticleRepository;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


/**
 * Сервис статей.
 * Расширяет класс {@link PostServiceImpl}, а таже реализует интерфейс {@link PostService}
 */
@Slf4j
@Service
public class ArticleServiceImpl
		extends PostServiceImpl<ArticleRepository>
		implements PostService<ArticleResponse, ArticleRequest> {

	/**
	 * Маппер.
	 * */
	private final ArticleMapper mapper;

	/**
	 * Конструктор
	 *
	 * @param repository
	 * 		репозиторий статей
	 * @param mapper
	 * 		маппер для конвертации объектов
	 */
	public ArticleServiceImpl (@NonNull final ArticleRepository repository, @NonNull final ArticleMapper mapper) {
		super(repository);
		this.mapper = mapper;
	}

	@NonNull
	@Override
	public ArticleResponse save (@NonNull final ArticleRequest request) {

		log.info("конвертация запроса в сущность");
		final Article article = mapper.toEntity(request);

		log.info(article.toString());
		log.info("сохранение новой записи");
		final Article result = repository.save(article);

		log.info(article.toString());
		return mapper.toResponse(result);
	}

	@NonNull
	@Override
	public ArticleResponse findById (@NonNull final UUID id) {
		return mapper.toResponse(repository.getById(id));
	}

	@NonNull
	@Override
	@Transactional
	public List<ArticleResponse> findByAuthor (@NonNull final String key) {
		log.info("аргумент author " + key + " передан в метод сервиса");
		log.info("делаем запрос в БД");
		final List<Article> articles = repository.findByAuthor(key);

		log.info("складываем все в респонс и возвращаем");
		return mapper.toResponseList(articles);
	}

	@NonNull
	@Override
	@Transactional
	public ArticleResponse edit (@NonNull final ArticleRequest request) {
		log.info(String.valueOf(request.getId()));
		final Article article = repository.getById(Objects.requireNonNull(request.getId()));
		article.setAuthor(Objects.requireNonNull(request.getAuthor()));
		article.setHeader(Objects.requireNonNull(request.getHeader()));
		article.setBody(Objects.requireNonNull(request.getBody()));
		article.setLastEdit(ZonedDateTime.now());
		final Article result = repository.save(article);
		return mapper.toResponse(result);
	}
}
