package ru.attempt.bugawa.postservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.attempt.bugawa.lib.model.entity.ParentEntity;
import ru.attempt.bugawa.lib.model.entity.PostEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Сущность публикации обзора. Расширяет класс сущности публикации {@link PostEntity}. ID сущности определяется в
 * основной родительской сущности {@link ParentEntity} из библиотеки publication-lib
 */
@Entity
@Table(name = "reviews", schema = "post")
@PrimaryKeyJoinColumn(name = "post_entity_id", columnDefinition = "uuid")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Review extends PostEntity {

	/**
	 * Связанная с обзором статья.
	 */
	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article article;

}
