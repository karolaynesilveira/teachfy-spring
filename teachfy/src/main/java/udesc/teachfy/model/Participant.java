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
@Table(name = "participants")
public class Participant {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "deck_id", referencedColumnName = "id")
	private Deck deck;

	@NotNull
	@Column(columnDefinition="smallint")
	private int permission;

	public Participant() {}

	public Participant(Long id, User user, Deck deck, int permission) {
		super();
		this.id = id;
		this.user = user;
		this.deck = deck;
		this.permission = permission;
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

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	
}
