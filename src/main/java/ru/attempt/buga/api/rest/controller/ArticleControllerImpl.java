package ru.attempt.buga.api.rest.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.attempt.buga.api.rest.ArticleApiV1;
import ru.attempt.buga.model.dto.request.ArticleRequest;
import ru.attempt.buga.model.dto.request.ArticleRequest;
import ru.attempt.buga.model.dto.response.ArticleResponse;
import ru.attempt.buga.service.GeneralService;

import java.util.UUID;

/**
 * 17.04.2022
 *
 * @author Евгений Анфимов
 */
@RestController
public class ArticleControllerImpl implements ArticleApiV1 {

	private final GeneralService<ArticleResponse, ArticleRequest, UUID> service;

	public ArticleControllerImpl(@Qualifier("articleServiceImpl") 
	                             GeneralService<ArticleResponse, ArticleRequest, UUID> service) {
		this.service = service;
	}

	@NonNull
	@Override
	public ResponseEntity<?> create(@NonNull final ArticleRequest request) {
		return ResponseEntity.ok().body(service.create(request));
	}

	@NonNull
	@Override
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@NonNull
	@Override
	public ResponseEntity<?> delete(@NonNull final UUID id) throws Exception {
		service.delete(id);
		if (!service.isExists(id)) {
			return ResponseEntity.ok().build();
		} else {
			throw new Exception("oops, не удалил");
		}
	}
}
