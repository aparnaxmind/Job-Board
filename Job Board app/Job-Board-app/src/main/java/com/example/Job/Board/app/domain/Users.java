package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = AUTO)

    private Long userId;
    private String username;
    private String password;



//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "users")
//    private Set<Role> role;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role role;
}
