package udesc.teachfy.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Option;
import udesc.teachfy.repository.OptionRepository;

public class OptionController extends CrudController<Option> {

	OptionRepository repository;
	
	public OptionController(OptionRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Option, Long> getRepository() {
		return repository;
	}

	@Override
	protected void setDataForUpdate(Option older, Option newer) {
		older.setDescription(newer.getDescription());
		older.setCorrectAnswer(newer.getCorrectAnswer());
	}
	
}
