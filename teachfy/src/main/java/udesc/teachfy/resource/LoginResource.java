package udesc.teachfy.resource;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import udesc.teachfy.model.Credential;
import udesc.teachfy.model.User;
import udesc.teachfy.repository.UserRepository;

public class LoginResource {

	UserRepository repository;
	
	public LoginResource(UserRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping(path="/login")
	public Boolean login(@RequestBody Credential credential){
		Optional<User> user = repository.findByEmailAndPassword(credential.getEmail(), credential.getPassword());
		if (!user.isEmpty()) {	
			Boolean password = BCrypt.checkpw(credential.getPassword(), user.get().getPassword());
				return password;
		}
		return false;
	}
	
}
