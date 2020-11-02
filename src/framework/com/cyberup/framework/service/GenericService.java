package com.cyberup.framework.service;


public interface GenericService<T> {
	T add(T entity);

	T update(T entity);

	void delete(int id);

	T get(int id);
}
