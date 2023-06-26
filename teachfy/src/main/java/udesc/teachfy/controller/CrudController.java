package udesc.teachfy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.User;

abstract public class CrudController<M> {

	protected abstract JpaRepository<M, Long> getRepository();

	public List<M> all() {
		return getRepository().findAll();
	}

	public M create(M record) {
		return getRepository().saveAndFlush(record);
	}
	
	public Optional<M> show(Long id) {
		return getRepository().findById(id);
	}

	public Optional<M> update(M record, Long id) {
		Optional<M> older = getRepository().findById(id);
		if (older.isPresent()) {
			setDataForUpdate(older.get(), record);
			getRepository().saveAndFlush(older.get());
		}
		return older;
	}
	
	protected void setDataForUpdate(M older, M newer) {}

	public void delete(Long id) {
		getRepository().deleteById(id);
	}
}
