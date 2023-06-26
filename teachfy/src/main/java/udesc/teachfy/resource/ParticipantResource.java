package udesc.teachfy.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.ParticipantController;
import udesc.teachfy.model.Participant;

@RequestMapping(path="/participants")
@RestController
public class ParticipantResource extends CrudResource<Participant> {

	ParticipantController controller;
	
	public ParticipantResource(ParticipantController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Participant> getController() {
		return controller;
	}
	
}
