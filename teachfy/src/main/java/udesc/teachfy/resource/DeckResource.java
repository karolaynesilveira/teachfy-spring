package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.model.Deck;
import udesc.teachfy.repository.DeckRepository;

@CrossOrigin(origins="http://localhost:5173")
@RequestMapping(path="/decks")
@RestController
public class DeckResource extends CrudResource<Deck> {

	DeckRepository repository;
	
	public DeckResource(DeckRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Deck, Long> getRepository() {
		return repository;
	}

	@Override
	protected void setDataForCreate(Deck record) {
		record.getCards().forEach((card) -> {
			card.setDeck(record);
		});
	}

	@Override
	protected void updateDataForResponse(Deck record) {
		record.getCards().forEach((card) -> {
			card.setDeck(null);
		});
	}

	@Override
	protected void setDataForUpdate(Deck older, Deck newer) {
		older.setFolder(newer.getFolder());
		older.setName(newer.getName());
		older.setPublico(newer.getPublico());
		older.setClonable(newer.getClonable());
		older.setFeedback(newer.getFeedback());		
		older.setType(newer.getType());
	}
	
}
