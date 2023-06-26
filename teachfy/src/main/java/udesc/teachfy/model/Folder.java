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
@Table(name = "folders")
public class Folder {
	
	@Id
	@GeneratedValue
	private Long id;

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

	public Folder() {}
	
	public Folder(Long id, Folder folder, String name, int publico, int clonable) {
		super();
		this.id = id;
		this.folder = folder;
		this.name = name;
		this.publico = publico;
		this.clonable = clonable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
}
