package udesc.teachfy.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.DeckController;
import udesc.teachfy.model.Deck;

@RequestMapping(path="/decks")
@RestController
public class DeckApi extends CrudApi<Deck> {

	DeckController controller;
	
	public DeckApi(DeckController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Deck> getController() {
		return controller;
	}
	
}
