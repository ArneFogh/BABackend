package eksamen.carsubscription.services;



import eksamen.carsubscription.entity.User;
import eksamen.carsubscription.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IUser userRepository;

    @Autowired
    public UserService(IUser userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public ResponseEntity<?> loginUser(String email, String password) {

        User user = findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok().body(Collections.singletonMap("valid", true));
        } else {
            return ResponseEntity.ok().body(Collections.singletonMap("valid", false));
        }
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setEmail(updatedUser.getEmail());

            return userRepository.save(existingUser);
        }

        return null;
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

