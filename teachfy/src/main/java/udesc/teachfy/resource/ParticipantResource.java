package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.model.Participant;
import udesc.teachfy.repository.ParticipantRepository;

@RequestMapping(path="/participants")
@RestController
public class ParticipantResource extends CrudResource<Participant> {

	ParticipantRepository repository;
	
	public ParticipantResource(ParticipantRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Participant, Long> getRepository() {
		return repository;
	}

	@Override
	protected void setDataForUpdate(Participant older, Participant newer) {
		older.setPermission(newer.getPermission());
	}
	
}
