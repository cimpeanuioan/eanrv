package ro.xdr.eanrv.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.xdr.eanrv.dao.UserDao;
import ro.xdr.eanrv.model.User;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by rares.urdea on 30.10.2014.
 */
@Repository
@Transactional("core")
public class UserDaoImpl extends AbstractEntityDaoImpl<User, Long> implements UserDao {

    public User getUserById(Long id) {
        Query query = entityManager.createQuery("FROM " + type.getSimpleName() + " AS table" + " WHERE table.id = :id");
        query.setParameter("id", id);
        List<User> result = query.getResultList();
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public List<User> getUsersByFirstName(String fn) {
        Query query = entityManager.createQuery("FROM " + type.getSimpleName() + " AS table" + " WHERE table.firstName = :fn");
        query.setParameter("fn", fn);
        List<User> result = query.getResultList();
        return result.size() > 0 ? result : null;
    }

    @Override
    public List<User> getUsersByLastName(String ln) {
        Query query = entityManager.createQuery("FROM " + type.getSimpleName() + " AS table" + " WHERE table.lastName = :ln");
        query.setParameter("ln", ln);
        List<User> result = query.getResultList();
        return result.size() > 0 ? result : null;
    }

    @Override
    public User getUserByToken(String fbToken) {
        Query query = entityManager.createQuery("FROM " + type.getSimpleName() + " AS table" + " WHERE table.facebookToken = :fbToken");
        query.setParameter("fbToken", fbToken);
        List<User> result = query.getResultList();
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = entityManager.createQuery("FROM " + type.getSimpleName() + " AS table" + " WHERE table.email = :email");
        query.setParameter("email", email);
        List<User> result = query.getResultList();
        return result.size() > 0 ? result.get(0) : null;
    }

    public Long getNumberOfUsers() {
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM " + type.getSimpleName());
        return (Long) query.getSingleResult();
    }
}
