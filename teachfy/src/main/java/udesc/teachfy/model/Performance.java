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
@Table(name = "performances")
public class Performance {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "card_id", referencedColumnName = "id")
	private Card card;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@NotNull
	@Column(columnDefinition="smallint")
	private int performance;

	public Performance() {}

	public Performance(Long id, Card card, User user, int performance) {
		super();
		this.id = id;
		this.card = card;
		this.user = user;
		this.performance = performance;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPerformance() {
		return performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}
	
}
