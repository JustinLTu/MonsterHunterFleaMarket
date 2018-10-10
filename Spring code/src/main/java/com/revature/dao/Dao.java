package com.revature.dao;

public interface Dao<T> {
	public T read(int id);
	public void create(T t);
	public boolean update(int id, T t);
	public void delete(T t);
}

