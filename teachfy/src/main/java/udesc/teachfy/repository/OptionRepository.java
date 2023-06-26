package udesc.teachfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {
	
}
