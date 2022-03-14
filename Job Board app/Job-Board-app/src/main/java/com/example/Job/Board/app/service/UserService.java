package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Employer;
import com.example.Job.Board.app.domain.Role;
import com.example.Job.Board.app.domain.Users;
import com.example.Job.Board.app.dtos.RoleDTO;
import com.example.Job.Board.app.dtos.UserDTO;
import com.example.Job.Board.app.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public Users saveUser(Users users) {
        log.info("saving user {} to the database",users.getUsername());
        //employer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return userRepository.save(users);
    }

    public List<UserDTO> getUser() {

        List<Users> listOfUser = userRepository.findAll();
        List<UserDTO>userDTOS = new ArrayList<>();
        listOfUser.forEach(detail -> {
            UserDTO user = new UserDTO();
            user.setUser_id(detail.getUser_id());
            user.setUsername(detail.getUsername());
            user.setPassword(detail.getPassword());
            user.setRole_id(detail.getRole_id());
            userDTOS.add(user);
        });
        return userDTOS;
    }

    public void addNewUser(UserDTO userDetails) {

        Users user = new Users();
        user.setUser_id(userDetails.getUser_id());
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole_id(userDetails.getRole_id());
        userRepository.save(user);

    }

    public void deleteUser(Long user_id) {
        boolean exists = userRepository.existsById(user_id);
        if (!exists) {
            throw new IllegalStateException("user with id " + user_id + "does not exists");
        }
        userRepository.deleteById(user_id);
    }
}
