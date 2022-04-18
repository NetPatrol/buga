package ru.attempt.buga.mapper;

import org.mapstruct.Mapper;
import ru.attempt.buga.model.entity.Comment;
import ru.attempt.buga.model.dto.request.CommentRequest;
import ru.attempt.buga.model.dto.response.CommentResponse;

import java.util.List;

@Mapper
public interface CommentMapper {

	Comment toEntity(CommentRequest request);

	CommentResponse toResponse(Comment comment);

	List<CommentResponse> toResponseList(List<Comment> comments);

}
