package ru.attempt.buga.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * 18.04.2022
 *
 * @author Евгений Анфимов
 */
@Data
public class BaseRequest {

	private String text;
	private String author;
	@JsonProperty("publishing_date")
	private ZonedDateTime date;
}
