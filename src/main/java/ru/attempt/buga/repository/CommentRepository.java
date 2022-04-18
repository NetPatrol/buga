package ru.attempt.buga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.attempt.buga.model.entity.Comment;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
