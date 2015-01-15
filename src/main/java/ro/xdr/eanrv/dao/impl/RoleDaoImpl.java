package ro.xdr.eanrv.dao.impl;

import org.springframework.stereotype.Repository;
import ro.xdr.eanrv.dao.RoleDao;
import ro.xdr.eanrv.model.Role;

import javax.persistence.Query;
import java.util.List;


@Repository
public class RoleDaoImpl extends AbstractEntityDaoImpl<Role, Long> implements RoleDao {

    @Override
    public Role getRoleById(Long id) {
        Query query = entityManager.createQuery("FROM " + type.getSimpleName() + " AS table" + " WHERE table.id = :id");
        query.setParameter("id", id);
        List<Role> result = query.getResultList();
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public Role getRoleByName(String roleName) {
        Query query = entityManager.createQuery("FROM " + type.getSimpleName() + " AS table" + " WHERE table.roleName = :roleName");
        query.setParameter("roleName", roleName);
        List<Role> result = query.getResultList();
        return result.size() > 0 ? result.get(0) : null;
    }
}
