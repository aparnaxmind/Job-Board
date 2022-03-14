package com.example.Job.Board.app.repo;


import com.example.Job.Board.app.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

   Optional<Users> findByUsername(String Username);
}
