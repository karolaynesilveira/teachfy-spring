package udesc.teachfy.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Folder;
import udesc.teachfy.repository.FolderRepository;

public class FolderController extends CrudController<Folder> {

	FolderRepository repository;
	
	public FolderController(FolderRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Folder, Long> getRepository() {
		return repository;
	}

	@Override
	protected void setDataForUpdate(Folder older, Folder newer) {
		older.setFolder(newer.getFolder());
		older.setName(newer.getName());
		older.setPublico(newer.getPublico());
		older.setClonable(newer.getClonable());
	}
	
}
