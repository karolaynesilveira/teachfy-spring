package udesc.teachfy.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.PerformanceController;
import udesc.teachfy.model.Performance;

@RequestMapping(path="/performances")
@RestController
public class PerformanceResource extends CrudResource<Performance> {

	PerformanceController controller;
	
	public PerformanceResource(PerformanceController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Performance> getController() {
		return controller;
	}
	
}
