package udesc.teachfy.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Performance;
import udesc.teachfy.repository.PerformanceRepository;

public class PerformanceController extends CrudController<Performance> {

	PerformanceRepository repository;
	
	public PerformanceController(PerformanceRepository repository) {
		this.repository = repository;
	}
	
	protected JpaRepository<Performance, Long> getRepository() {
		return repository;
	}

	@Override
	protected void setDataForUpdate(Performance older, Performance newer) {
		older.setPerformance(newer.getPerformance());
	}
	
}
