package com.revature.service;

public interface Service<T> {
	public T read(int id);
	public void create(T object);
	public boolean update(int id, T object);
	public void delete(T object);
}
