package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role,Long>{
//    Optional<Role> findById(Long roleId);
}
