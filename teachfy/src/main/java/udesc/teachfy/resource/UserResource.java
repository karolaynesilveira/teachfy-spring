package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
