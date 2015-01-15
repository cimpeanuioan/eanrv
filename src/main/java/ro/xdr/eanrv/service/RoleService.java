package ro.xdr.eanrv.service;

import ro.xdr.eanrv.model.Operation;
import ro.xdr.eanrv.model.Role;


public interface RoleService {

    public Role getRoleByName(String roleName);

    public Operation hasRight(Long id);

    public Role isAllowed(Long id);
}
