package ro.xdr.eanrv.service;

import ro.xdr.eanrv.model.User;

import java.util.List;

/**
 * Created by rares.urdea on 30.10.2014.
 */
public interface UserService {

    public int saveUser(User user);

    public User getUser(Long id);

    public User getUserByToken(String facebookToken);

    public User getUserByEmail(String email);

    public List<User> getAll();

    public User getAuthenticatedUser();
}
