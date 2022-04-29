package ru.attempt.bugawa.postservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.attempt.buga.lib.model.ParentEntity;
import ru.attempt.buga.lib.model.entity.PostEntity;

import javax.persistence.DiscriminatorValue;
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
@DiscriminatorValue("review")
@Table(name = "reviews", schema = "post")
@PrimaryKeyJoinColumn(name = "post_entity_id", columnDefinition = "uuid")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Review extends PostEntity {

	/**
	 * Связанная с обзором статья.
	 */
	@ManyToOne
	@JoinColumn(name = "article_id", referencedColumnName = "post_entity_id")
	private ru.attempt.bugawa.postservice.model.entity.Article article;

	@Override
	public boolean equals (final Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		final Review review = (Review) o;
		return this.getId() != null && Objects.equals(this.getId(), review.getId());
	}

	@Override
	public int hashCode () {
		return this.getClass().hashCode();
	}
}
