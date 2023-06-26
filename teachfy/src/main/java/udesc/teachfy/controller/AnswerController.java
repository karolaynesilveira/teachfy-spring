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

	@Override
	protected void setDataForUpdate(Answer older, Answer newer) {
		older.setOption(newer.getOption());
		older.setDifficulty(newer.getDifficulty());
		older.setGrade(newer.getGrade());
		older.setFeedback(newer.getFeedback());
	}
	
}
