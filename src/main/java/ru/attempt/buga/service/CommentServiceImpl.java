package ru.attempt.buga.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.attempt.buga.mapper.CommentMapper;
import ru.attempt.buga.model.entity.Comment;
import ru.attempt.buga.model.dto.request.CommentRequest;
import ru.attempt.buga.model.dto.response.CommentResponse;
import ru.attempt.buga.repository.CommentRepository;

import java.util.List;
import java.util.UUID;

/**
 * 17.04.2022
 *
 * @author Евгений Анфимов
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements GeneralService<CommentResponse, CommentRequest, UUID> {

	private final CommentRepository repository;
	private final CommentMapper mapper;

	@Override
	public CommentResponse create(@NonNull final CommentRequest request) {
		Comment comment = mapper.toEntity(request);
		return mapper.toResponse(repository.save(comment));
	}

	@Override
	public List<CommentResponse> findAll() {
		return mapper.toResponseList(repository.findAll());
	}

	@Override
	public boolean isExists(final UUID id) {
		return repository.existsById(id);
	}

	@Override
	public void delete(@NonNull final UUID id) {
		Comment comment = repository.getById(id);
		repository.delete(comment);
	}
}
