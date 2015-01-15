package ro.xdr.eanrv.security;

import ro.xdr.eanrv.model.User;

/**
 * Created by marius.boeru on 14.11.2014.
 */
public interface IBaseAuthenticationProvider {

    User connect (String authToken);
}
