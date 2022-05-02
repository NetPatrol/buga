package ru.attempt.bugawa.postservice.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.attempt.bugawa.lib.repository.PostRepository;
import ru.attempt.bugawa.postservice.model.entity.Article;

import java.util.List;

/**
 * Репозиторий для работы со статьями. Расширяет класс {@link PostRepository}
 * */
@Repository
public interface ArticleRepository extends PostRepository<Article> {

	/**
	 * Метод поиска статьи по автору.
	 * */
	@Query("SELECT a FROM Article a where a.author = ?1")
	List<Article> findByAuthor (@NonNull final String key);

}
