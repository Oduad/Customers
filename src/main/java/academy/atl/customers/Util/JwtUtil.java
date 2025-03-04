package academy.atl.customers.Util;

import academy.atl.customers.Entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {

    public static final String SECRET_KEY = "Oduad";
    public static Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
    public static String generateToken(User user){
        String token = JWT.create()
                .withIssuer("ATLAcademy")
                .withClaim("userId", user.getId())
                .withIssuedAt(new Date())
                .withExpiresAt(expiresDate())
                .sign(algorithm);
        return token;
    }

    private static Date expiresDate(){
        return new Date(System.currentTimeMillis()
                +(1000L*60*60*24*14));
    }

    public static String getUserIdByToken(String token){
        JWTVerifier verifier= JWT.require(algorithm)
                .withIssuer("ATLAcademy")
                .build();

        DecodedJWT decoded = verifier.verify(token);
        String userId = decoded.getClaim("userId").toString();
        return userId;
    }

}
