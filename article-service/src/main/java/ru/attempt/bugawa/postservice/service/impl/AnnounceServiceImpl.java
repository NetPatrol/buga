package ru.attempt.bugawa.postservice.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.attempt.buga.lib.repository.PostRepository;
import ru.attempt.buga.lib.service.PostServiceImpl;
import ru.attempt.bugawa.postservice.mapper.AnnounceMapper;
import ru.attempt.bugawa.postservice.model.dto.request.AnnounceRequest;
import ru.attempt.bugawa.postservice.model.dto.response.AnnounceResponse;
import ru.attempt.bugawa.postservice.model.entity.Announce;

import java.util.List;
import java.util.Objects;

/**
 *
 */
@Slf4j
@Service
public class AnnounceServiceImpl extends PostServiceImpl<Announce, AnnounceResponse, AnnounceRequest, String> {

	private final AnnounceMapper mapper;

	/**
	 * Конструктор
	 *
	 * @param repository
	 * 		репозиторий анонсов
	 * @param mapper
	 * 		маппер маппер для конвертации объектов
	 */
	public AnnounceServiceImpl (@NonNull final PostRepository<Announce> repository,
	                            @NonNull final AnnounceMapper mapper) {
		super(repository);
		this.mapper = mapper;
	}

	@NonNull
	@Override
	public AnnounceResponse save (@NonNull final AnnounceRequest request) {
		final Announce announce = mapper.toEntity(request);
		return mapper.toResponse(repository.save(announce));
	}

	@NonNull
	@Override
	public List<AnnounceResponse> findAll () {
		return mapper.toResponseList(repository.findAll());
	}

	@NonNull
	@Override
	public List<AnnounceResponse> findByKey (@NonNull final String key) {
		final List<Announce> announces = repository.findById(key).stream().toList();
		return mapper.toResponseList(announces);
	}

	@NonNull
	@Override
	public AnnounceResponse edit (@NonNull final AnnounceRequest request) {
		final Announce announce = repository.getById(Objects.requireNonNull(request.getId()));
		final Announce result = repository.save(announce);
		return mapper.toResponse(result);
	}
}
