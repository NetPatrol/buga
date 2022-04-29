CREATE TABLE post.reviews
(
    post_entity_id UUID NOT NULL,
    article_id     UUID,
    CONSTRAINT pk_reviews PRIMARY KEY (post_entity_id)
);

ALTER TABLE post.reviews
    ADD CONSTRAINT uc_reviews_post_entity UNIQUE (post_entity_id);

ALTER TABLE post.reviews
    ADD CONSTRAINT FK_REVIEWS_ON_ARTICLE FOREIGN KEY (article_id) REFERENCES post.articles (post_entity_id);

ALTER TABLE post.reviews
    ADD CONSTRAINT FK_REVIEWS_ON_POST_ENTITY FOREIGN KEY (post_entity_id) REFERENCES post.post_entity (id);