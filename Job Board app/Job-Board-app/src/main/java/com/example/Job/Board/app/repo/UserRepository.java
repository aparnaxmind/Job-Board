package com.example.Job.Board.app.repo;


import com.example.Job.Board.app.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
   Users findByUsername(String Username);
}
