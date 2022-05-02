package ru.attempt.bugawa.postservice.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import ru.attempt.bugawa.lib.model.entity.ParentEntity;
import ru.attempt.bugawa.lib.repository.PostRepository;
import ru.attempt.bugawa.lib.service.PostService;

import java.util.UUID;

/**
 * Базовый сервис для работы с постами любых типов. Реализует базовый интерфейс сервиса {@link PostService}.
 * содержит общие для всех методы.
 * @param <R> тип сущности поста с которой работает репозиторий
 */
@Slf4j
public class PostServiceImpl<R extends PostRepository<? extends ParentEntity>> {

	/**
	 * Абстрактный репозиторий, параметризуемый типом сущности поста с которым работает сервис.
	 * */
	protected final R repository;

	/**
	 * Конструктор.
	 *
	 * @param repository абстрактный репозиторий, параметризуемый типом сущности поста с которым работает сервис.
	 * */
	public PostServiceImpl (@NonNull final R repository) {
		this.repository = repository;
	}

	/**
	 * Проверка на существование записи в БД.
	 * @param id - id сущности для проверки
	 * @return возвращает true, если запись существует, иначе false
	 * */
	public boolean isExists (@NonNull final UUID id) {
		return repository.existsById(id);
	}

	/**
	 * Удаление записи в БД.
	 * @param id - id сущности для удаления
	 * */
	public void deleteById (@NonNull final UUID id) {
		repository.deleteById(id);
	}
}
