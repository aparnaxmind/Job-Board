package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployerDetails {
    private Long employer_id;
    private String Company_name;
    private String Address;
    private String City;
    private String State;
    private String Email;
    private String Website;
    private String Mobileno;
    private Long user_id;
}
