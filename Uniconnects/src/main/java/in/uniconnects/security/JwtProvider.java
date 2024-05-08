package in.uniconnects.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {

    String jwtSecret = "secretSecretSNakknighvvhbhgdvcbnjasdvghcvgbhjnbhvgcfgvbhjnbhvgfcfxdcgvbhjn";

    long jwtExpirationInMs=60000;

    public String generateJwtToken(Authentication authentication){
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        Map<String, String> claimsMap = new HashMap<>(1);
        claimsMap.put(Claims.SUBJECT, userPrincipal.getUsername());
        claimsMap.put("name", userPrincipal.getName());
        claimsMap.put("email", userPrincipal.getEmail());
        claimsMap.put("phoneNumber", userPrincipal.getPhoneNumber());

        Key key = Keys.hmacShaKeyFor((jwtSecret).getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setClaims(claimsMap)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public String getUsername(String authToken){

        if(authToken!=null){
            Claims claims = Jwts.parser().setSigningKey((jwtSecret).getBytes(StandardCharsets.UTF_8)).build().parseClaimsJwt(authToken).getBody();
            return claims.getSubject();
        }
        return null;

    }

}
