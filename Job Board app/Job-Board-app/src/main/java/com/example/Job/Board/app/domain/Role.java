package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long roleId;
    private String roleName;


//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name ="userId",referencedColumnName = "userId")
//    private  Users users;
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "users")
//    private Set<Role> role;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Users> users;
}
