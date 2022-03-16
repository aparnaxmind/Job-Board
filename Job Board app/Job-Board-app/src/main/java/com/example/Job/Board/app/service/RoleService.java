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
            rol.setRoleId(detail.getRoleId());
            rol.setRoleName(detail.getRoleName());
            roleDTOS.add(rol);
        });
        return roleDTOS;
    }

    public void addNewRole(RoleDTO roleDetails) {

        Role role = new Role();
        role.setRoleId(roleDetails.getRoleId());
        role.setRoleName(roleDetails.getRoleName());

        roleRepository.save(role);

    }

    public void deleteRole(Long roleId) {
        boolean exists = roleRepository.existsById(roleId);
        if (!exists) {
            throw new IllegalStateException("role with id " + roleId + "does not exists");
        }
        roleRepository.deleteById(roleId);
    }

}
