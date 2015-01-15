package ro.xdr.eanrv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ro.xdr.eanrv.dao.OperationDao;
import ro.xdr.eanrv.dao.RoleDao;
import ro.xdr.eanrv.dao.UserDao;
import ro.xdr.eanrv.model.Operation;
import ro.xdr.eanrv.model.Role;
import ro.xdr.eanrv.model.User;
import ro.xdr.eanrv.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    UserDao userDao;

    @Autowired
    OperationDao operationDao;

    @Autowired
    RoleDao roleDao;

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }

    @Override
    public Operation hasRight(Long id) {
        final String userDetails = SecurityContextHolder.getContext().getAuthentication().getName();
        final User authUser = userDao.getUserByEmail(userDetails);
        for (final Role role : authUser.getRoles()) {
            if (role.getOperations().contains(operationDao.find(id))) {
                return operationDao.find(id);
            }
        }
        return null;
    }

    @Override
    public Role isAllowed(Long id) {
        final String userDetails = SecurityContextHolder.getContext().getAuthentication().getName();
        final User authUser = userDao.getUserByEmail(userDetails);
        for (final Role role : authUser.getRoles()) {
            if (role.getId().equals(roleDao.find(id))) {
                return roleDao.find(id);
            }
        }
        return null;
    }
}
