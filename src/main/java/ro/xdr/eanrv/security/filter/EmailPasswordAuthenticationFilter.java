package ro.xdr.eanrv.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Created by marius.boeru on 14.11.2014.
 */
public class EmailPasswordAuthenticationFilter extends
        UsernamePasswordAuthenticationFilter {

    public static final Logger logger = LoggerFactory.getLogger(EmailPasswordAuthenticationFilter.class);
    public static final String LOGON_URI = "/";
    private static final String AUTHORIZATION = "Authorization";
    private static final String FACEBOOK_TOKEN = "X-FB-Token";
    private static final String GOOGLE_TOKEN = "X-GOOGLE-Token";

    // Note to self: if shit doesn't work, add accept header
    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");

        setPostOnly(false);
        super.doFilter(req, response, chain);

    }

    @Override
    protected String obtainUsername(final HttpServletRequest request) {
        String authorization = request.getHeader(AUTHORIZATION);
        if (authorization != null && authorization.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.decode(base64Credentials.getBytes()),
                    Charset.forName("UTF-8"));
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            return values[0];
        }

        authorization = request.getHeader(FACEBOOK_TOKEN);
        if (authorization != null){
            return FACEBOOK_TOKEN + authorization;
        }

        authorization = request.getHeader(GOOGLE_TOKEN);
        if (authorization != null){
            return GOOGLE_TOKEN + authorization;
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @Override
    protected String obtainPassword(final HttpServletRequest request) {
        String authorization = request.getHeader(AUTHORIZATION);

        if (authorization != null && authorization.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.decode(base64Credentials.getBytes()),
                    Charset.forName("UTF-8"));
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            return values[1];
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("password")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    // always returns false for dev purposes
    @Override
    protected boolean requiresAuthentication(final HttpServletRequest request,
                                             final HttpServletResponse response) {
        boolean requires = true;
        final HashMap<String, String> unsecuredUris = new HashMap<String, String>();
        unsecuredUris.put("/user/register", "POST");
        unsecuredUris.put("/auto", "GET");
        unsecuredUris.put("/hotelauto", "GET");
        unsecuredUris.put("/dated", "ALL");
        unsecuredUris.put("/dateless", "ALL");
        unsecuredUris.put("/priceCheck","ALL");
        unsecuredUris.put("/weather", "ALL");
        final String uri = request.getRequestURI();
        for (final String unsecuredUri : unsecuredUris.keySet()) {
            if (uri.contains(unsecuredUri) && (unsecuredUris.get(unsecuredUri).equals("ALL") || unsecuredUris.get(unsecuredUri).equals(request.getMethod()))) {
                requires = false;
                break;
            }
        }
        return false;
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request,
                                            final HttpServletResponse response, final FilterChain chain,
                                            final Authentication authResult) throws IOException, ServletException {

        if (logger.isDebugEnabled()) {
            logger.debug("Authentication success. Updating SecurityContextHolder to contain: "
                    + authResult);
        }
        SecurityContextHolder.getContext().setAuthentication(authResult);

        // Fire event
        if (this.eventPublisher != null) {
            eventPublisher
                    .publishEvent(new InteractiveAuthenticationSuccessEvent(
                            authResult, this.getClass()));
        }

        if (isLoginPage(request)) {
            getSuccessHandler().onAuthenticationSuccess(request, response,
                    authResult);
        } else {
            chain.doFilter(request, response);
        }
    }

    private boolean isLoginPage(final HttpServletRequest request) {
        String uri = request.getRequestURI();
        final int pathParamIndex = uri.indexOf(';');

        if (pathParamIndex > 0) {
            uri = uri.substring(0, pathParamIndex);
        }

        if ("".equals(request.getContextPath())) {
            return uri.endsWith(LOGON_URI);
        }

        return uri.endsWith(request.getContextPath() + LOGON_URI);
    }
}
