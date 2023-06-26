package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.model.Card;
import udesc.teachfy.repository.CardRepository;

@RequestMapping(path="/cards")
@RestController
public class CardResource extends CrudResource<Card> {

	CardRepository repository;
	
	public CardResource(CardRepository repository) {
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
