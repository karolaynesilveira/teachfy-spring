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
@Table(name = "options")
public class Option {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "card_id", referencedColumnName = "id")
	private Card card;
	
	@NotNull
	private String description;
	
	@NotNull
	@Column(columnDefinition="smallint")
	private int correct_answer;

	public Option() {}

	public Option(Long id, @NotNull Card card, @NotNull String description, @NotNull int correct_answer) {
		super();
		this.id = id;
		this.card = card;
		this.description = description;
		this.correct_answer = correct_answer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(int correct_answer) {
		this.correct_answer = correct_answer;
	}
	
}
