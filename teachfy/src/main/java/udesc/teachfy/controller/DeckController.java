package udesc.teachfy.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Deck;
import udesc.teachfy.repository.DeckRepository;

public class DeckController extends CrudController<Deck> {

	DeckRepository repository;
	
	public DeckController(DeckRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Deck, Long> getRepository() {
		return repository;
	}
	
}
