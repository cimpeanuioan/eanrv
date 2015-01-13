package ro.xdr.eanrv.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

/**
 * Created by marius.boeru on 18.11.2014.
 */
public class AuthenticationFailureEventListener implements
        ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent) {

    }
}
