package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Employer;
import com.example.Job.Board.app.domain.Users;
import com.example.Job.Board.app.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
