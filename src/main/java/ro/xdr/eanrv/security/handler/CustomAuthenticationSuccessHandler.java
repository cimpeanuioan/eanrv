package ro.xdr.eanrv.security.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javassist.NotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ro.xdr.eanrv.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by marius.boeru on 14.11.2014.
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final String authTokenHeader = "authToken";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        final Map<String, Object> details = (java.util.Map<String, Object>) authentication.getDetails();
        final String token = (String) details.get("token");

        httpServletResponse.setHeader(authTokenHeader, token);
        httpServletResponse.setHeader("Content-Type", "application/json");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        final PrintWriter out = httpServletResponse.getWriter();
        try {
            out.write(createJsonResponse(details));
        } catch (final NotFoundException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }

    private String createJsonResponse(final Map<String, Object> details) throws NotFoundException {
        final User account = (User) details.get("user");
        final Gson gson = new GsonBuilder().create();
        final String json = gson.toJson(account);
        return json;
    }
}
