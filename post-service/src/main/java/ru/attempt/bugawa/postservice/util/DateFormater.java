package ru.attempt.bugawa.postservice.util;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormater {

	String dateFormat(ZonedDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy - HH:mm:ss Z");
		return dateTime.format(formatter);
	}

}
