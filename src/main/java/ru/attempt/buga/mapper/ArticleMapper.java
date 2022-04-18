package ru.attempt.buga.mapper;

import org.mapstruct.Mapper;
import ru.attempt.buga.model.entity.Article;
import ru.attempt.buga.model.dto.request.ArticleRequest;
import ru.attempt.buga.model.dto.response.ArticleResponse;

import java.util.List;

@Mapper
public interface ArticleMapper {

	Article toEntity(ArticleRequest request);

	ArticleResponse toResponse(Article article);

	List<ArticleResponse> toResponseList(List<Article> articles);

}
