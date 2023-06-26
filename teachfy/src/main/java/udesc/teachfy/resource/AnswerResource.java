package udesc.teachfy.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.AnswerController;
import udesc.teachfy.model.Answer;

@RequestMapping(path="/answers")
@RestController
public class AnswerResource extends CrudResource<Answer> {

	AnswerController controller;
	
	public AnswerResource(AnswerController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Answer> getController() {
		return controller;
	}
	
}
