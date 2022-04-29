package ru.attempt.bugawa.postservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.attempt.buga.lib.model.ParentEntity;
import ru.attempt.buga.lib.model.entity.PostEntity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Сущность публикации статьи. Расширяет класс сущности публикации {@link PostEntity}. ID сущности определяется в
 * основной родительской сущности {@link ParentEntity} из библиотеки publication-lib
 */
@Entity
@DiscriminatorValue("article")
@Table(name = "articles", schema = "post")
@PrimaryKeyJoinColumn(name = "post_entity_id", columnDefinition = "uuid")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Article extends PostEntity {

	/**
	 * Коллекция связанных с публикацией обзоров (рецензий).
	 */
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "article", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private Set<ru.attempt.bugawa.postservice.model.entity.Review> reviews = new HashSet<>();

	@Override
	public boolean equals (final Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		final Article article = (Article) o;
		return this.getId() != null && Objects.equals(this.getId(), article.getId());
	}

	@Override
	public int hashCode () {
		return this.getClass().hashCode();
	}
}
