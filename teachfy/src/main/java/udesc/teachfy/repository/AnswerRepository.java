package udesc.teachfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
}
