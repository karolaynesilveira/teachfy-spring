package udesc.teachfy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.dto.Login;
import udesc.teachfy.dto.Response;
import udesc.teachfy.model.User;
import udesc.teachfy.service.TokenService;

@RestController
public class LoginApi {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping(path="/login")
	public ResponseEntity<Response<String>> login(@RequestBody Login login){
		try {
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login.email(), login.password());
			Authentication auth = this.authenticationManager.authenticate(authToken);
			User user = (User) auth.getPrincipal();
			String token = tokenService.generateToken(user);
			return new ResponseEntity(new Response("Login efetuado com sucesso", token), HttpStatus.OK);			
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
}
