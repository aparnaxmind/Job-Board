package com.example.Job.Board.app.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Skills {
    @Id
    @GeneratedValue(strategy = AUTO)

    private Long skillId;
    private String skillName;

    @ManyToMany(mappedBy = "skills")
    private Set<Jobs> jobsDetails ;
}
