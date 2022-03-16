package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Jobs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface JobsRepository extends JpaRepository<Jobs,Long> {
    //Optional<Jobs> findByJob_id(Long job_id) ;

    //Optional<Jobs> findBySkill_id(Long skill_id);
//    @Query("select c from City c where c.name like %?1")
//    List<City> findByNameEndsWith(String chars);
    @Query("SELECT j FROM Skills j WHERE j.skillId= :skillId  ")
    List<Jobs> findJobBySkill(@Param("skillId") Long skillId);



}
