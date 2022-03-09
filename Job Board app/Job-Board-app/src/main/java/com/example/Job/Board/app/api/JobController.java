package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Users;
import com.example.Job.Board.app.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class JobController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public List<Users> getUsers() {
        return this.userRepository.findAll();
    }
}
