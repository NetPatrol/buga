package ru.attempt.bugawa.postservice.meta;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostOpenApiTag {

	/**
	 * Метка для описания API анонсов.
	 */
	public static final String ANNOUNCE_API_TAG = "API анонсов";

	/**
	 * Метка для описания API статей.
	 */
	public static final String ARTICLE_API_TAG = "API статей";

	/**
	 * Метка для описания API рецензий.
	 */
	public static final String REVIEW_API_TAG = "API рецензий";

}
