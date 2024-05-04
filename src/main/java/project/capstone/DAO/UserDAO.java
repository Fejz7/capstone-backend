package project.capstone.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import project.capstone.entities.User;

public interface UserDAO extends JpaRepository<User,Integer> {
}
