package ro.xdr.eanrv.dao;

import java.util.List;

public interface EntityDao<T, I> {
	T find(final I id);

	List<T> getAll();

	T save(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(I id);

}
