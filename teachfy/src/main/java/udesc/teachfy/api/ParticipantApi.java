package udesc.teachfy.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.ParticipantController;
import udesc.teachfy.model.Participant;

@RequestMapping(path="/participants")
@RestController
public class ParticipantApi extends CrudApi<Participant> {

	ParticipantController controller;
	
	public ParticipantApi(ParticipantController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Participant> getController() {
		return controller;
	}
	
}
