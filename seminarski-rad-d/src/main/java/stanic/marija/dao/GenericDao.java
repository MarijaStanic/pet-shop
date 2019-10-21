package stanic.marija.dao;

public interface GenericDao<PK,T> {
	
	T getByKey(PK key);
	
	void persist(T entity);
	
	void update(T entity);
	
	void delete(T entity);
}
