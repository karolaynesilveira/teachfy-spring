package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.model.Performance;
import udesc.teachfy.repository.PerformanceRepository;

@RequestMapping(path="/performances")
@RestController
public class PerformanceResource extends CrudResource<Performance> {

	PerformanceRepository repository;
	
	public PerformanceResource(PerformanceRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Performance, Long> getRepository() {
		return repository;
	}
	
}
