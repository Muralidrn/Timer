// UserController.java
package com.example.TimerBackend.Controller;

import com.example.TimerBackend.DTO.userResponse;
import com.example.TimerBackend.Model.User;
import com.example.TimerBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/timer")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // ❗ Hash password in production (e.g. BCrypt)
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public userResponse login(@RequestBody User user) {
        Optional<User> dbUser = userRepo.findByUsername(user.getUsername());
        if (dbUser.isPresent() && dbUser.get().getPassword().equals(user.getPassword())) {
            userResponse userResponse=new userResponse(dbUser.get());
            System.out.println(userResponse.getLastClockInDate());
            return userResponse;
        }
        throw new RuntimeException("Invalid credentials");
    }
}
