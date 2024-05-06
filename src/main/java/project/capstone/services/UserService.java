package project.capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.capstone.DAO.UserDAO;
import project.capstone.entities.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User getUserById(int id) {
        Optional<User> optionalUser = userDAO.findById(id);
        return optionalUser.orElse(null);
    }

    public User addUser(User user) {
        return userDAO.save(user);
    }

    public User updateUser(int id, User user) {
        if (userDAO.existsById(id)) {
            user.setId(id);
            return userDAO.save(user);
        }
        return null;
    }

    public void deleteUser(int id) {
        userDAO.deleteById(id);
    }
}
