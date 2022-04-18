package ru.attempt.buga.exception;

/**
 * 18.04.2022
 *
 * @author Евгений Анфимов
 */
public class ArticleNotFoundException extends Exception {

	public ArticleNotFoundException() {
		super("запись не найдена");
	}
}
