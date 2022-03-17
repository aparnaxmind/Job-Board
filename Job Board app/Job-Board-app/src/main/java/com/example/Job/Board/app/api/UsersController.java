package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.JobDTO;
import com.example.Job.Board.app.dtos.UserDTO;
import com.example.Job.Board.app.repo.JobsRepository;
import com.example.Job.Board.app.repo.UserRepository;
import com.example.Job.Board.app.service.JobService;
import com.example.Job.Board.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class UsersController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUser(){
        List<UserDTO> userList=userService.getUser();
        if(userList.isEmpty())
            throw new IllegalMonitorStateException("User list is empty");
        return userList;
    }

    @PostMapping("/users/save")
    public void addNewUser(@RequestBody UserDTO userDTO){
        userService.addNewUser(userDTO);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId")Long userId){
        userService.deleteUser(userId);
    }


}
