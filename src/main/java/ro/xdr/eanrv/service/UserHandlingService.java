package ro.xdr.eanrv.service;

import ro.xdr.eanrv.model.User;

import java.util.List;

/**
 * Created by rares.urdea on 30.10.2014.
 */
public interface UserHandlingService {

    public int registerNewUser(User user);

    public User createUserByAdmin(User user);

    public User updateUser(User user);

    public User suspendUser(User user);

    public List<User> getAllUsers();
}
