package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.domain.Employer;

import com.example.Job.Board.app.domain.Jobs;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployerRepository extends JpaRepository<Employer,Long> {

    //Optional<Employer> findByEmployer_id(Long employer_id);
    @Query("SELECT j FROM Employer j WHERE j.employerId= :employerId  ")
    List<Jobs> findByjobId(@Param("employerId") Long employerId);
//    Optional<Jobs> findByjob_id(Long employer_id);
//    Optional<Applicant> findByApplicant_id(Long applicant_id);



}
