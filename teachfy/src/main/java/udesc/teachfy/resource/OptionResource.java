package udesc.teachfy.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.OptionController;
import udesc.teachfy.model.Option;

@RequestMapping(path="/options")
@RestController
public class OptionResource extends CrudResource<Option> {

	OptionController controller;
	
	public OptionResource(OptionController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Option> getController() {
		return controller;
	}
	
}
