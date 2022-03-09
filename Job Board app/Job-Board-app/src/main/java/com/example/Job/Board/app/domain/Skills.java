package com.example.Job.Board.app.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Skills {
    private Long skill_id;
    private String SkillName;
}
