package ru.attempt.bugawa.postservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.attempt.bugawa.lib.model.entity.ParentEntity;
import ru.attempt.bugawa.lib.model.entity.PostEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Сущность публикации статьи. Расширяет класс сущности публикации {@link PostEntity}. ID сущности определяется в
 * основной родительской сущности {@link ParentEntity} из библиотеки publication-lib
 */
@Entity
@Table(name = "articles", schema = "post")
@PrimaryKeyJoinColumn(name = "post_entity_id", columnDefinition = "uuid")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, exclude = "reviews")
public class Article extends PostEntity {

	/**
	 * Коллекция связанных с публикацией обзоров (рецензий).
	 */
	@ToString.Exclude
	@OneToMany(mappedBy = "article")
	private Set<Review> reviews = new HashSet<>();

}
