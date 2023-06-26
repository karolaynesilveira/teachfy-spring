package udesc.teachfy.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.AnswerController;
import udesc.teachfy.model.Answer;

@RequestMapping(path="/answers")
@RestController
public class AnswerApi extends CrudApi<Answer> {

	AnswerController controller;

	public AnswerApi(AnswerController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Answer> getController() {
		return controller;
	}
	
}
