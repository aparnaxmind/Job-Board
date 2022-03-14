package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Role;
import com.example.Job.Board.app.dtos.RoleDTO;
import com.example.Job.Board.app.repo.RoleRepository;

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
public class RoleService {
    private final RoleRepository roleRepository;

    public List<RoleDTO> getRole() {

        List<Role> listOfRole = roleRepository.findAll();
        List<RoleDTO> roleDTOS = new ArrayList<>();
        listOfRole.forEach(detail -> {
            RoleDTO rol = new RoleDTO();
            rol.setRole_id(detail.getRole_id());
            rol.setRole_name(detail.getRole_name());
            roleDTOS.add(rol);
        });
        return roleDTOS;
    }

    public void addNewRole(RoleDTO roleDetails) {

        Role role = new Role();
        role.setRole_id(roleDetails.getRole_id());
        role.setRole_name(roleDetails.getRole_name());

        roleRepository.save(role);

    }

    public void deleteRole(Long role_id) {
        boolean exists = roleRepository.existsById(role_id);
        if (!exists) {
            throw new IllegalStateException("role with id " + role_id + "does not exists");
        }
        roleRepository.deleteById(role_id);
    }

}
