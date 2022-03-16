package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Employer {
    @Id
    @GeneratedValue(strategy = AUTO)

    private Long employerId;
    private String companyName;
    private String address;
    private String city;
    private String state;
    private String email;
    private String website;
    private String mobileNo;
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employer")
    private Set<Jobs> jobs;


    @Override
    public String toString() {
        return "Employer [employerId = " + employerId+ ", companyName= " +companyName + ", email = " + email + ", website = " + website
                + ", mobileNo = " + mobileNo + ", userId = " +userId+ ",address = " +address +  "]";
    }
}
