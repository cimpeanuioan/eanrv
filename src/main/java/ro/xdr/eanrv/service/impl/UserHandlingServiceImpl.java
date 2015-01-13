package ro.xdr.eanrv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.xdr.eanrv.model.Role;
import ro.xdr.eanrv.model.User;
import ro.xdr.eanrv.security.SecurityUtil;
import ro.xdr.eanrv.service.RoleService;
import ro.xdr.eanrv.service.UserHandlingService;
import ro.xdr.eanrv.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rares.urdea on 30.10.2014.
 */
@Service
public class UserHandlingServiceImpl implements UserHandlingService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public int registerNewUser(User user) {
        final List<Role> roles = new ArrayList<>();
        final String hashedPassword = SecurityUtil.encodePassword(user.getPassword());
        user.setPassword(hashedPassword);
        roles.add(roleService.getRoleByName("User"));
        user.setRoles(roles);
        user.setActive(true);
        userService.saveUser(user);
        return 1;
    }

    @Override
    public User createUserByAdmin(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User suspendUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
