package udesc.teachfy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "answers")
public class Answer {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "card_id", referencedColumnName = "id")
	private Card card;

	@ManyToOne
	@JoinColumn(name = "option_id", referencedColumnName = "id")
	private Option option;
	
	@Column(columnDefinition="text")
	private String difficulty;

	@Column(columnDefinition="numeric(5,2)")
	private Double grade;

	@Column(columnDefinition="text")
	private String feedback;

	public Answer() {}

	public Answer(Long id, @NotNull User user, @NotNull Card card, Option option, String difficulty, Double grade,
			String feedback) {
		super();
		this.id = id;
		this.user = user;
		this.card = card;
		this.option = option;
		this.difficulty = difficulty;
		this.grade = grade;
		this.feedback = feedback;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
