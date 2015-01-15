package ro.xdr.eanrv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ro.xdr.eanrv.dao.UserDao;
import ro.xdr.eanrv.model.User;
import ro.xdr.eanrv.service.UserService;

import java.util.List;

/**
 * Created by rares.urdea on 30.10.2014.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int saveUser(User user) {
        userDao.save(user);
        return 1;
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByToken(String facebookToken) {
        return userDao.getUserByToken(facebookToken);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public List<User> getUsersByFirstName(String firstName) {
        return userDao.getUsersByFirstName(firstName);
    }

    public List<User> getUsersByLastName(String lastName) {
        return userDao.getUsersByLastName(lastName);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getAuthenticatedUser() {
        final String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }
}
