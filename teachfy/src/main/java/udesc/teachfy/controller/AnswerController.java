package udesc.teachfy.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Answer;
import udesc.teachfy.repository.AnswerRepository;

public class AnswerController extends CrudController<Answer> {

	AnswerRepository repository;
	
	public AnswerController(AnswerRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Answer, Long> getRepository() {
		return repository;
	}
	
}
