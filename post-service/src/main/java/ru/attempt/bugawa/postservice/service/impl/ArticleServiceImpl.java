package ru.attempt.bugawa.postservice.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.attempt.buga.lib.repository.PostRepository;
import ru.attempt.buga.lib.service.PostServiceImpl;
import ru.attempt.bugawa.postservice.mapper.ArticleMapper;
import ru.attempt.bugawa.postservice.model.dto.request.ArticleRequest;
import ru.attempt.bugawa.postservice.model.dto.response.ArticleResponse;
import ru.attempt.bugawa.postservice.model.entity.Article;

import java.util.List;
import java.util.Objects;

/**
 *
 */
@Slf4j
@Service
public class ArticleServiceImpl extends PostServiceImpl<Article, ArticleResponse, ArticleRequest, String> {

	private final ArticleMapper mapper;

	/**
	 * Конструктор
	 *
	 * @param repository
	 * 		репозиторий статей
	 * @param mapper
	 * 		маппер для конвертации объектов
	 */
	public ArticleServiceImpl (@NonNull final PostRepository<Article> repository,
	                           @NonNull final ArticleMapper mapper) {
		super(repository);
		this.mapper = mapper;
	}

	@NonNull
	@Override
	public ArticleResponse save (@NonNull final ArticleRequest request) {
		final Article article = mapper.toEntity(request);
		return mapper.toResponse(repository.save(article));
	}

	@NonNull
	@Override
	public List<ArticleResponse> findAll () {
		return mapper.toResponseList(repository.findAll());
	}

	@NonNull
	@Override
	public List<ArticleResponse> findByKey (@NonNull final String key) {
		final List<Article> articles = repository.findById(key).stream().toList();
		return mapper.toResponseList(articles);
	}

	@NonNull
	@Override
	public ArticleResponse edit (@NonNull final ArticleRequest request) {
		final Article article = repository.getById(Objects.requireNonNull(request.getId()));
		final Article result = repository.save(article);
		return mapper.toResponse(result);
	}
}
