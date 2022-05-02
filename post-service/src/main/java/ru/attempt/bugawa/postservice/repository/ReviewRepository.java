package ru.attempt.bugawa.postservice.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.attempt.bugawa.lib.repository.PostRepository;
import ru.attempt.bugawa.postservice.model.entity.Review;

import java.util.List;

/**
 * репозиторий для работы со обзорами. Расширяет класс {@link PostRepository}
 * */
@Repository
public interface ReviewRepository extends PostRepository<Review> {

	/**
	 * Метод поиска обзора по автору.
	 * */
	@Query("SELECT r FROM Review r where r.author = ?1")
	List<Review> findByAuthor (@NonNull final String key);
}
