package udesc.teachfy.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.controller.FolderController;
import udesc.teachfy.model.Folder;

@RequestMapping(path="/folders")
@RestController
public class FolderResource extends CrudResource<Folder> {

	FolderController controller;
	
	public FolderResource(FolderController controller) {
		this.controller = controller;
	}
	
	protected CrudController<Folder> getController() {
		return controller;
	}
	
}
