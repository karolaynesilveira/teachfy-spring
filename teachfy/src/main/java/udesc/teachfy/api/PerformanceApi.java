package udesc.teachfy.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.PerformanceController;
import udesc.teachfy.model.Performance;

@RequestMapping(path="/performances")
@RestController
public class PerformanceApi extends CrudApi<Performance> {

	PerformanceController controller;
	
	public PerformanceApi(PerformanceController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Performance> getController() {
		return controller;
	}
	
}
