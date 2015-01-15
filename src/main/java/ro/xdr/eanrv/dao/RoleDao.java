package ro.xdr.eanrv.dao;

import ro.xdr.eanrv.model.Role;


public interface RoleDao extends EntityDao<Role, Long> {

    Role getRoleById(Long id);

    Role getRoleByName(String roleName);
}
