package ru.attempt.buga.api.rest;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.attempt.buga.api.Api;
import ru.attempt.buga.model.dto.request.CommentRequest;

import java.util.UUID;

public interface CommentApiV1 extends Api {
	@NonNull
	@PostMapping("/api/v1")
	ResponseEntity<?> create(@RequestBody @NonNull final CommentRequest request);
	@NonNull
	@GetMapping("/api/v1")
	ResponseEntity<?> findAll();
	@NonNull
	@DeleteMapping
	ResponseEntity<?> delete(@RequestParam @NonNull final UUID id) throws Exception;
}
