package ro.xdr.eanrv.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import ro.xdr.eanrv.dao.EntityDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Transactional
public abstract class AbstractEntityDaoImpl<T, I> implements EntityDao<T, I> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<T> type;

	private final Log LOG = LogFactory.getLog(AbstractEntityDaoImpl.class);

	public AbstractEntityDaoImpl() {
		Class<?> superClass = getClass();
		Type superType = superClass.getGenericSuperclass();
		while (!(superType instanceof ParameterizedType) && superClass != null) {
			superType = (superClass = superClass.getSuperclass()).getGenericSuperclass();
		}
		if (superType instanceof ParameterizedType) {
			ParameterizedType superclass = (ParameterizedType) superType;
			type = (Class<T>) superclass.getActualTypeArguments()[0];
		}
	}

	protected void setentityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public T find(I id) {
		return entityManager.find(type, id);
	}

	public T save(final T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	public void update(final T entity) {
		entityManager.merge(entity);
		entityManager.flush();
	}

	public void delete(final T entity) {
		entityManager.remove(entity);
		entityManager.flush();
	}

	public List<T> getAll() {
		List<T> resultList = entityManager.createQuery("FROM " + type.getName()).getResultList();

		return resultList;
	}

	public void deleteById(I id) {
		final T entity = find(id);
		delete(entity);
	}

}
