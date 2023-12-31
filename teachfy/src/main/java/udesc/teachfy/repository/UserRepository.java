package udesc.teachfy.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import udesc.teachfy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email, String senha);
	
}
