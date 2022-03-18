package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Employer;
import com.example.Job.Board.app.domain.Role;
import com.example.Job.Board.app.domain.Users;
import com.example.Job.Board.app.dtos.RoleDTO;
import com.example.Job.Board.app.dtos.UserDTO;
import com.example.Job.Board.app.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getUser() {

        List<Users> listOfUser = userRepository.findAll();
        List<UserDTO>userDTOS = new ArrayList<>();
        listOfUser.forEach(detail -> {
            UserDTO user = new UserDTO();
            user.setUserId(detail.getUserId());
            user.setUsername(detail.getUsername());
            user.setPassword(detail.getPassword());

            userDTOS.add(user);
        });
        return userDTOS;
    }

    public void addNewUser(UserDTO userDetails) {

        Users user = new Users();
        user.setUserId(userDetails.getUserId());
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());

        userRepository.save(user);

    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id " + userId + "does not exists");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if(users==null){
            log.error("Customer not found in the database");
        }
        else{
            log.info("Customer found in the database:{}",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        users.getRole().forEach(role -> { authorities.add(new SimpleGrantedAuthority(role.getRoleName()));});
        authorities.add(new SimpleGrantedAuthority(users.getRole().getRoleName()));



        return new User(users.getUsername(),users.getPassword(),authorities);
    }
    }

