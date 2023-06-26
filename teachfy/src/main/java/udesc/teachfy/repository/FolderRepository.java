package udesc.teachfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {
	
}
