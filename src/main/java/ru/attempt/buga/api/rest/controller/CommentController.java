package ru.attempt.buga.api.rest.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.attempt.buga.api.rest.CommentApiV1;
import ru.attempt.buga.model.dto.request.CommentRequest;
import ru.attempt.buga.model.dto.response.CommentResponse;
import ru.attempt.buga.service.GeneralService;

import java.util.UUID;

/**
 * 17.04.2022
 *
 * @author Евгений Анфимов
 */
@RestController
public class CommentController implements CommentApiV1 {

	private final GeneralService<CommentResponse, CommentRequest, UUID> service;

	public CommentController(@Qualifier("commentServiceImpl")
	                         GeneralService<CommentResponse, CommentRequest, UUID> service) {
		this.service = service;
	}

	@NonNull
	@Override
	public ResponseEntity<?> create(@NonNull final CommentRequest request) {
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
			throw new Exception("не удалил");
		}

	}
}
