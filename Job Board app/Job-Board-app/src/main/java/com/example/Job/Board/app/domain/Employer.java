package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Employer {
    @Id
    @GeneratedValue(strategy = AUTO)

    private Long employer_id;
    private String company_name;
    private String address;
    private String city;
    private String state;
    private String email;
    private String website;
    private String mobile_no;
    private Long user_id;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "jobsDetails")
    private List<Jobs> jobsDetailsListList;


    @Override
    public String toString() {
        return "Employer [employer_id = " + employer_id+ ", company_name= " +company_name + ", email = " + email + ", website = " + website
                + ", mobile_no = " + mobile_no + ", user_id = " +user_id+ ",address = " +address +  "]";
    }
}
