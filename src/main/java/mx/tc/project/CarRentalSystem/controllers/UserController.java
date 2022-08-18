package mx.tc.project.CarRentalSystem.controllers;

import mx.tc.project.CarRentalSystem.models.User;
import mx.tc.project.CarRentalSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUser")
    public List<User> findAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User finUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public User findUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        return userService.deleteById(id);
    }

}
