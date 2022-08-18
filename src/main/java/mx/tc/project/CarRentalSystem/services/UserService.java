package mx.tc.project.CarRentalSystem.services;

import mx.tc.project.CarRentalSystem.models.User;
import mx.tc.project.CarRentalSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "User removed";
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        assert existingUser != null;
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getName());
        existingUser.setTelephone(user.getTelephone());
        existingUser.setUser_created(user.getUser_created());
        return userRepository.save(existingUser);
    }


}
