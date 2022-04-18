package ru.attempt.buga.model.dto.response;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * 18.04.2022
 *
 * @author Евгений Анфимов
 */
@Data
public class BaseResponse {
	private String text;
	private String author;
	private ZonedDateTime date;
}
