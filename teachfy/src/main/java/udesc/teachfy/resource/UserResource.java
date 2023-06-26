package udesc.teachfy.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.UserController;
import udesc.teachfy.model.User;

@RequestMapping(path="/users")
@RestController
public class UserResource extends CrudResource<User>{

	UserController controller;
	
	public UserResource(UserController controller) {
		this.controller = controller;
	}
	
	protected CrudController<User> getController() {
		return controller;
	}
	
}
