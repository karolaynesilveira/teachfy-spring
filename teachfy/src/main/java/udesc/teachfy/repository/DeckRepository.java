package udesc.teachfy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {
	
	List<Deck> findByUserId(Long userId);
	
}
