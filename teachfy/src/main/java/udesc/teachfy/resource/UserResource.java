package udesc.teachfy.resource;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import udesc.teachfy.model.Credential;
import udesc.teachfy.model.User;
import udesc.teachfy.repository.UserRepository;

public class UserResource {

	UserRepository repository;
	
	public UserResource(UserRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping(path="/login")
	public Boolean autenticar(@RequestBody Credential credential){
		Optional<User> user = repository.findByEmailAndPassword(credential.getEmail(), credential.getPassword());
		if (!user.isEmpty()) {	
			Boolean password = BCrypt.checkpw(credential.getPassword(), user.get().getPassword());
				return password;
		}
		return false;
	}
	
	@GetMapping(path="/users")
	public List<User> listarUsuarios() {
		return repository.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User lerUsuario(@PathVariable Long id) {
		Optional<User> record = repository.findById(id);
		return !record.isEmpty() ? record.get() : null;
	}
	
}
