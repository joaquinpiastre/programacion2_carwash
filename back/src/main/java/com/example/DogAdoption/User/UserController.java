package com.example.DogAdoption.User;

import com.example.DogAdoption.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired

    private UserService userService;


    @GetMapping("/getall")
    public ArrayList<User> getUser() {
        return this.userService.getUser();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }


    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);

        if(ok){
            return "User with Id" + id + "has been deleted";
        } else {
            return "Error, User with Id" + id + "has not been deleted";
        }
    }

    @PutMapping(path = "/{id}")
    public User updateUser(@RequestBody User request, @PathVariable("id") Long id) {
        return this.userService.updateUser(request, id);
    }
}
