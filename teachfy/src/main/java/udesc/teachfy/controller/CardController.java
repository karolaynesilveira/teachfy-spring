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

	@Override
	protected void setDataForUpdate(Card older, Card newer) {
		older.setType(newer.getType());
		older.setQuestion(newer.getQuestion());
		older.setAnswer(newer.getAnswer());
		older.setPoints(newer.getPoints());
	}
	
}
