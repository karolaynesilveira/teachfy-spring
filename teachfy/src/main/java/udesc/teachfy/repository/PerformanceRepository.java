package udesc.teachfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
	
}
