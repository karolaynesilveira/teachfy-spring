package udesc.teachfy.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import udesc.teachfy.model.User;
import udesc.teachfy.repository.UserRepository;

public class UserController extends CrudController<User>{

	UserRepository repository;
	
	public UserController(UserRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<User, Long> getRepository() {
		return repository;
	}

	@Override
	public User create(User record) {
		BCryptPasswordEncoder bcrypy = new BCryptPasswordEncoder();
        record.setPassword(bcrypy.encode(record.getPassword()));
		return super.create(record);
	}

	@Override
	protected void setDataForUpdate(User older, User newer) {
		older.setName(newer.getName());
		older.setEmail(newer.getEmail());

		BCryptPasswordEncoder bcrypy = new BCryptPasswordEncoder();
		older.setPassword(bcrypy.encode(newer.getPassword()));
	}
	
}
