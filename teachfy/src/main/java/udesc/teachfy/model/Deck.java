package udesc.teachfy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "decks", uniqueConstraints={@UniqueConstraint(columnNames = {"id" , "type"})})
public class Deck {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "folder_id", referencedColumnName = "id")
	private Folder folder;
	
	@NotNull
	private String name;

	@NotNull
	@Column(name="public", columnDefinition="smallint default '0'")
	private int publico;

	@NotNull
	@Column(columnDefinition="smallint default '0'")
	private int clonable;

	@NotNull
	@Column(columnDefinition="smallint default '0'")
	private int feedback;
	
	@NotNull
	@Column(columnDefinition="smallint")
	private int type;

	public Deck() {}
	
	public Deck(Long id, User user, Folder folder, String name, int publico, int clonable, int feedback, int type) {
		super();
		this.id = id;
		this.user = user;
		this.folder = folder;
		this.name = name;
		this.publico = publico;
		this.clonable = clonable;
		this.feedback = feedback;
		this.type = type;
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

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPublico() {
		return publico;
	}

	public void setPublico(int publico) {
		this.publico = publico;
	}

	public int getClonable() {
		return clonable;
	}

	public void setClonable(int clonable) {
		this.clonable = clonable;
	}

	public int getFeedback() {
		return feedback;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
