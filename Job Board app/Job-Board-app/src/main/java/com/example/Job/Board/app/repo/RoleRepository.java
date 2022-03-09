package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role,Long>{
    Role findByid(Long role_id);
}
