package dao;

import java.util.List;

import banco.MySQLDatabase;

public abstract class DAO<E> {

	protected MySQLDatabase database;
	
	public DAO(MySQLDatabase database) {
		this.database = database;
	}
	
	public abstract boolean insert (E object);
	
	public abstract List<E> getAll();
}
