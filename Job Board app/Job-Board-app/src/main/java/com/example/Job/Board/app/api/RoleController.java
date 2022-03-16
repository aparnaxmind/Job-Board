package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.domain.Role;
import com.example.Job.Board.app.dtos.JobDTO;
import com.example.Job.Board.app.dtos.RoleDTO;
import com.example.Job.Board.app.repo.JobsRepository;
import com.example.Job.Board.app.repo.RoleRepository;
import com.example.Job.Board.app.service.JobService;
import com.example.Job.Board.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class RoleController {
    @Autowired
    private RoleRepository roleRepository;
    private RoleService roleService;

    @GetMapping
    public List<RoleDTO> getRole(){
        List<RoleDTO> roleList=roleService.getRole();
        if(roleList.isEmpty())
            throw new IllegalMonitorStateException("Role list is empty");
        return roleList;
    }
    @PostMapping
    public void addNewRole(@RequestBody RoleDTO roleDTO){
        roleService.addNewRole(roleDTO);
    }
    @DeleteMapping(path = "{roleId}")
    public void deleteRole(@PathVariable("roleId")Long roleId){
        roleService.deleteRole(roleId);
    }

}
