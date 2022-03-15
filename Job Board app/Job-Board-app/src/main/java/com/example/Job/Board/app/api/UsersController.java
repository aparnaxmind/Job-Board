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

public class UsersController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUser(){
        List<UserDTO> userList=userService.getUser();
        if(userList.isEmpty())
            throw new IllegalMonitorStateException("User list is empty");
        return userList;
    }

    @PostMapping
    public void addNewUser(@RequestBody UserDTO userDTO){
        userService.addNewUser(userDTO);
    }
    @DeleteMapping(path = "{user_id}")
    public void deleteUser(@PathVariable("user_id")Long user_id){
        userService.deleteUser(user_id);
    }


}
