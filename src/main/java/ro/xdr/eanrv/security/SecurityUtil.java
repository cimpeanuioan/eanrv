package ro.xdr.eanrv.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ro.xdr.eanrv.model.Role;
import ro.xdr.eanrv.model.User;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by marius.boeru on 18.11.2014.
 */
public class SecurityUtil {

    private static final int MAX_LENGTH = 20;

    private SecurityUtil() {
    }

    public static String encodePassword(final String password) {
        SecureRandom random = new SecureRandom();
        String salt = new BigInteger(130, random).toString(32);
        final BASE64Encoder encoder = new BASE64Encoder();
        final String encodedPass = encoder.encodeBuffer((password+salt).getBytes());
        return encodedPass.trim();
    }

    public static Collection<SimpleGrantedAuthority> getAuthorities(final User user) {
        final Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        final List<Role> roles = user.getRoles();
        for (final Role role : roles) {
            //for (final Operation op : role.getOperations()) {
                authorities.add(new SimpleGrantedAuthority(role
                        .getRoleName()));
            //}
        }
        return authorities;
    }

    public static String generateSalt() {
        String salt;
        final int radix = 16;
        final SecureRandom random = new SecureRandom();
        final byte[] bytes = new byte[MAX_LENGTH];
        random.nextBytes(bytes);
        salt = new BigInteger(1, bytes).toString(radix).substring(0, MAX_LENGTH);
        return salt;
    }

}
