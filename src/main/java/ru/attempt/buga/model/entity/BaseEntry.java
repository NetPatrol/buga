package ru.attempt.buga.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * 17.04.2022
 *
 * @author Евгений Анфимов
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntry implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false, unique = true)
	private UUID id;

	@NotBlank
	@Column(name = "text", nullable = false, length = 145)
	private String text;

	@NotBlank
	@Column(name = "author", nullable = false, length = 20)
	private String author;

	@Column(name = "publishing_date")
	private ZonedDateTime date;
}
