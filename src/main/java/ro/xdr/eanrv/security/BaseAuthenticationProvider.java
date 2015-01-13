package ro.xdr.eanrv.security;

import ro.xdr.eanrv.model.User;
import ro.xdr.eanrv.service.UserService;

/**
 * Created by marius.boeru on 14.11.2014.
 */
public class BaseAuthenticationProvider implements IBaseAuthenticationProvider {

    private UserService userService;

    public BaseAuthenticationProvider() {}

    public BaseAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User connect(String authToken) {
        return null;
    }

}
