package udesc.teachfy.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import udesc.teachfy.model.User;

@Service
public class TokenService {
	
	public String generateToken(User user) {
		return JWT.create()
				  .withIssuer("Teachfy")
				  .withSubject(user.getEmail())
				  .withClaim("id", user.getId())
				  .withExpiresAt(LocalDateTime.now().plusMinutes(120).toInstant(ZoneOffset.of("-03:00")))
				  .sign(Algorithm.HMAC256("survivor"));
	}
	
	public String getSubject(String token) {
		return JWT.require(Algorithm.HMAC256("survivor"))
				  .withIssuer("Teachfy")
				  .build().verify(token).getSubject();
	}
}
