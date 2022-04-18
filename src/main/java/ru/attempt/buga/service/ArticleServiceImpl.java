package ru.attempt.buga.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.attempt.buga.mapper.ArticleMapper;
import ru.attempt.buga.model.entity.Article;
import ru.attempt.buga.model.dto.request.ArticleRequest;
import ru.attempt.buga.model.dto.response.ArticleResponse;
import ru.attempt.buga.repository.ArticleRepository;

import java.util.List;
import java.util.UUID;

/**
 * 17.04.2022
 *
 * @author Евгений Анфимов
 */

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements GeneralService<ArticleResponse, ArticleRequest, UUID> {

	private final ArticleRepository repository;
	private final ArticleMapper mapper;

	@NonNull
	@Override
	public ArticleResponse create(@NonNull final ArticleRequest request) {
		Article article = mapper.toEntity(request);
		return mapper.toResponse(repository.save(article));
	}

	@NonNull
	@Override
	public List<ArticleResponse> findAll() {
		return mapper.toResponseList(repository.findAll());
	}

	@Override
	public boolean isExists(final UUID id) {
		return repository.existsById(id);
	}

	@Override
	public void delete(@NonNull final UUID id) {
		Article Article = repository.getById(id);
		repository.delete(Article);
	}
}
