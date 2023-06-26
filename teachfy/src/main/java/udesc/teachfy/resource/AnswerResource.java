package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.model.Answer;
import udesc.teachfy.repository.AnswerRepository;

@RequestMapping(path="/answers")
@RestController
public class AnswerResource extends CrudResource<Answer> {

	AnswerRepository repository;
	
	public AnswerResource(AnswerRepository repository) {
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
