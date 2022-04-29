package ru.attempt.bugawa.postservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.attempt.buga.lib.model.ParentEntity;
import ru.attempt.buga.lib.model.entity.PostEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Сущность публикации аннонса. Расширяет класс сущности публикации {@link PostEntity}. ID сущности определяется в
 * основной родительской сущности {@link ParentEntity} из библиотеки publication-lib
 */
@Entity
@DiscriminatorValue("announce")
@Table(name = "announces", schema = "post")
@PrimaryKeyJoinColumn(name = "post_entity_id", columnDefinition = "uuid")
@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true)
public class Announce extends PostEntity {

	@Override
	public boolean equals (final Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		final Announce announce = (Announce) o;
		return this.getId() != null && Objects.equals(this.getId(), announce.getId());
	}

	@Override
	public int hashCode () {
		return this.getClass().hashCode();
	}
}
