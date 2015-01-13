package ro.xdr.eanrv.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

/**
 * Created by marius.boeru on 18.11.2014.
 */
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {

    }
}
