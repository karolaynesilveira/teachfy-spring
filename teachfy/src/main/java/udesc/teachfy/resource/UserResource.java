package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.dto.Response;
import udesc.teachfy.model.User;
import udesc.teachfy.repository.UserRepository;

@RequestMapping(path="/users")
@RestController
public class UserResource extends CrudResource<User>{

	UserRepository repository;
	
	public UserResource(UserRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<User, Long> getRepository() {
		return repository;
	}

	@Override
	@PostMapping
	public ResponseEntity<Response<User>> create(@RequestBody User record) {
		try {
			BCryptPasswordEncoder bcrypy = new BCryptPasswordEncoder();
	        record.setPassword(bcrypy.encode(record.getPassword()));
			User newRecord = getRepository().saveAndFlush(record); 
			return new ResponseEntity(new Response("Registro salvo com sucesso", newRecord), HttpStatus.OK);
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}
