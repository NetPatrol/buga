CREATE TABLE post.articles
(
    post_entity_id UUID NOT NULL,
    CONSTRAINT pk_articles PRIMARY KEY (post_entity_id)
);

ALTER TABLE post.articles
    ADD CONSTRAINT uc_articles_post_entity UNIQUE (post_entity_id);

ALTER TABLE post.articles
    ADD CONSTRAINT FK_ARTICLES_ON_POST_ENTITY FOREIGN KEY (post_entity_id) REFERENCES post.post_entity (id);