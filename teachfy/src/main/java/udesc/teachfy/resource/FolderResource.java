package udesc.teachfy.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.model.Folder;
import udesc.teachfy.repository.FolderRepository;

@RequestMapping(path="/folders")
@RestController
public class FolderResource extends CrudResource<Folder> {

	FolderRepository repository;
	
	public FolderResource(FolderRepository repository) {
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
