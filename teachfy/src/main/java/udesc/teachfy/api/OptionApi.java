package udesc.teachfy.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.OptionController;
import udesc.teachfy.model.Option;

@RequestMapping(path="/options")
@RestController
public class OptionApi extends CrudApi<Option> {

	OptionController controller;
	
	public OptionApi(OptionController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Option> getController() {
		return controller;
	}
	
}
