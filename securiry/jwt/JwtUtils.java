package com.disenotuweb.segurizarAplicacion.securiry.jwt;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.disenotuweb.segurizarAplicacion.service.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${disenotuweb.app.jwtSecret}")/**lo hemos pasado en el aplication**/
    private String jwtSecret;

    @Value("${disenotuweb.app.jwtExpirationMs}")
    private int jwtExpirationMs;
/**Generamos token**/
    public String generateJwtToken(Authentication authentication) {
// Usuario principal
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
//Construimoa el TOKEN lo firmamos con sign y utilizamos el secret
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))// le pasamos el usuario
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))//Fecha de expiración
                .signWith(SignatureAlgorithm.HS512, jwtSecret)// firmamos
                .compact();
    }
/**Obteneos el nombre de usuario del token en este caso subject es el nombre de usuario**/
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
// las exceptiones,
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {// token fallo en la firma
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {// que el token esta mal formado
            logger.error("Invalid JWT token: {}", e.getMessage());// token invalido
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());// token expirado
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());// token np soportado
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());// token vacio
        }

        return false;
    }
}