package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Users {
    private Long user_id;
    private String Username;
    private String Password;
    private Long role_id;
}
