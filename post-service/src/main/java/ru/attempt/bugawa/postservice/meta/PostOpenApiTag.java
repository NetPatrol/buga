package ru.attempt.bugawa.postservice.meta;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Класс мета данных, содержащий тэги API для отображения в swagger
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostOpenApiTag {

	/**
	 * Метка для описания API статей.
	 */
	public static final String ARTICLE_API_TAG = "API статей";

	/**
	 * Метка для описания API рецензий.
	 */
	public static final String REVIEW_API_TAG = "API рецензий";

}
