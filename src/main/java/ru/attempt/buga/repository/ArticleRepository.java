package ru.attempt.buga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.attempt.buga.model.entity.Article;

import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
}
