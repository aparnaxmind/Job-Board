package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Role {
    private Long role_id;
    private String role_name;
}
