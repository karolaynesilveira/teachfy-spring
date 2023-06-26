package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.model.Option;
import udesc.teachfy.repository.OptionRepository;

@RequestMapping(path="/options")
@RestController
public class OptionResource extends CrudResource<Option> {

	OptionRepository repository;
	
	public OptionResource(OptionRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Option, Long> getRepository() {
		return repository;
	}
	
}
