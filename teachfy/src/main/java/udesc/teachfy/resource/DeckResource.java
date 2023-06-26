package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.model.Deck;
import udesc.teachfy.repository.DeckRepository;

@RequestMapping(path="/answers")
@RestController
public class DeckResource extends CrudResource<Deck> {

	DeckRepository repository;
	
	public DeckResource(DeckRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Deck, Long> getRepository() {
		return repository;
	}
	
}
