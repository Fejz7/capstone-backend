package project.capstone.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import project.capstone.entities.User;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
