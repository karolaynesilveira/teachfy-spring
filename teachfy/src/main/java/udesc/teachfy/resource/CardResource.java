package udesc.teachfy.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.CardController;
import udesc.teachfy.model.Card;

@RequestMapping(path="/cards")
@RestController
public class CardResource extends CrudResource<Card> {

	CardController controller;
	
	public CardResource(CardController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Card> getController() {
		return controller;
	}
	
}
