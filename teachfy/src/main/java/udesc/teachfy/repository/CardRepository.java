package udesc.teachfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
	
}
