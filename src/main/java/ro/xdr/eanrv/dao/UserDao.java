package ro.xdr.eanrv.dao;

import ro.xdr.eanrv.model.User;

import java.util.List;

/**
 * Created by rares.urdea on 30.10.2014.
 */
public interface UserDao extends EntityDao<User, Long> {

    User getUserById(Long id);

    User getUserByToken(String facebookToken);

    User getUserByEmail(String email);

    List<User> getUsersByFirstName(String firstName);

    List<User> getUsersByLastName(String lastName);

    Long getNumberOfUsers();
}
