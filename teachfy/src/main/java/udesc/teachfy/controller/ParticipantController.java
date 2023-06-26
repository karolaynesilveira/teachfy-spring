package udesc.teachfy.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Participant;
import udesc.teachfy.repository.ParticipantRepository;

public class ParticipantController extends CrudController<Participant> {

	ParticipantRepository repository;
	
	public ParticipantController(ParticipantRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Participant, Long> getRepository() {
		return repository;
	}
	
}
