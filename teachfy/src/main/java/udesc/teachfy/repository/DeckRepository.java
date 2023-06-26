package udesc.teachfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {
	
}
