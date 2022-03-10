package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = AUTO)

    private Long user_id;
    private String Username;
    private String password;
    private Long role_id;
}
