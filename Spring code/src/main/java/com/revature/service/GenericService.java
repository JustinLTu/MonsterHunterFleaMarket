package com.revature.service;

public interface GenericService<T> {
	public T read(int id);
	public void create(T object);
	public T update(int id, T object);
	public void delete(T object);
}
