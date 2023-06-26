package udesc.teachfy.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.CardController;
import udesc.teachfy.model.Card;

@RequestMapping(path="/cards")
@RestController
public class CardApi extends CrudApi<Card> {

	CardController controller;
	
	public CardApi(CardController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Card> getController() {
		return controller;
	}
	
}
