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
	
}
