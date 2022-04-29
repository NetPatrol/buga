CREATE TABLE post.announces
(
    post_entity_id UUID NOT NULL,
    CONSTRAINT pk_announces PRIMARY KEY (post_entity_id)
);

ALTER TABLE post.announces
    ADD CONSTRAINT uc_announces_post_entity UNIQUE (post_entity_id);

ALTER TABLE post.announces
    ADD CONSTRAINT FK_ANNOUNCES_ON_POST_ENTITY FOREIGN KEY (post_entity_id) REFERENCES post.post_entity (id);