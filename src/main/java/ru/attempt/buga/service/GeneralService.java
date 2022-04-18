package ru.attempt.buga.service;

import java.util.List;

public interface GeneralService<T, E, K> {

	T create(E request);
	List<T> findAll();
	boolean isExists(K id);
	void delete(K id);
}
