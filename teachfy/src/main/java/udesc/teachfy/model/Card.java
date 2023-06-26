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
@Table(name = "cards")
public class Card {
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "deck_id", referencedColumnName = "id")
	private Deck deck;
	
	@NotNull
	@Column(columnDefinition="smallint")
	private int type;
	
	@NotNull
	@Column(columnDefinition="text")
	private String question;

	@Column(columnDefinition="text")
	private String answer;

	@Column(columnDefinition="numeric(5,2)")
	private Double points;
	
	public Card() {}

	public Card(Long id, Deck deck, int type, String question, String answer, Double points) {
		super();
		this.id = id;
		this.deck = deck;
		this.type = type;
		this.question = question;
		this.answer = answer;
		this.points = points;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}
	
	
}
