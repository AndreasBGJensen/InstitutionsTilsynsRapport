package Controller.UserController;


import Model.DTO.User.UserDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Calendar;

public class JWTHandler{

    private static Key key;
    private static final int TOKEN_EXPIRY = 2880; //2 days

    public static String generateJwtToken(UserDTO user){
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, TOKEN_EXPIRY);
        return Jwts.builder()
                .setIssuer("GiraffeDeluxe")
                .claim("user", user)
                .signWith(SignatureAlgorithm.HS512, getKey())
                .setExpiration(expiry.getTime())
                .compact();
    }


    private static Key getKey(){
//Generate a secret key, if there is none specified in the environment - only use fixed key in development for debugging
        if (key==null) {
            if (System.getenv("JWT_SECRET_KEY")!= null && System.getenv("JWT_SECRET_KEY") != "") {
                String string = System.getenv("JWT_SECRET_KEY");
                key = new SecretKeySpec(string.getBytes(), 0, string.length(), "HS512");
            } else {
                key = MacProvider.generateKey(SignatureAlgorithm.HS512);
            }
        }
        return key;
    }

    public static UserDTO validateToken(String tokenString) {
        Claims claims = null;
        try{
            claims =
                    Jwts.parser()
                            .setSigningKey(key)
                            .parseClaimsJws(tokenString)
                            .getBody();
            if(claims != null) {
                UserDTO user = new UserDTO();
                //TODO: Hvordan får jeg de enkelte dele ud????
                System.out.println(claims.get("user").toString());
                System.out.println(claims.get("roles"));
                System.out.println(claims.getSubject());
                System.out.println(claims.getSubject());
                return user;
            }

        } catch (ExpiredJwtException | UnsupportedJwtException |
                MalformedJwtException | SignatureException
                | IllegalArgumentException e) {
            // Do something with those exceptions!

        }

        return null;

    }

}
