package win.amos.sweettools.iam.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

public class JWTHelper {

    public static String createToken(String username) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, 1);

        Algorithm algorithm = Algorithm.HMAC256("Amos");
        return JWT.create().withIssuer("SweetTools")
                .withAudience(username)
                .withIssuedAt(now)
                .withExpiresAt(calendar.getTime())
                .sign(algorithm);
    }

    public static boolean varifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256("Amos");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("SweetTools")
                .build();
        try {
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }

        return true;
    }
}
