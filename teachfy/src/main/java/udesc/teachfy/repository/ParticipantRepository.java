package udesc.teachfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	
}
