package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Role;
import com.example.Job.Board.app.repo.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;

    public Role saveRoles(Role role) {
        log.info("saving roles {} to the database",role.getRole_id());
        //employer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return roleRepository.save(role);
    }

}
