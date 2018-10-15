package com.revature.dao;

public interface Dao<T> {
	public T read(int id);
	public int create(T t);
	public T update(int id, T t);
	public void delete(T t);
}

