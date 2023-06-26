package udesc.teachfy.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Card;
import udesc.teachfy.repository.CardRepository;

public class CardController extends CrudController<Card> {

	CardRepository repository;
	
	public CardController(CardRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Card, Long> getRepository() {
		return repository;
	}
	
}
