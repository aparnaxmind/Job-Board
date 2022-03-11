package com.example.Job.Board.app.dtos;

import lombok.Data;

@Data
public class EmployerDTO {
    private Long employer_id;
    private String company_name;
    private String address;
    private String city;
    private String state;
    private String email;
    private String website;
    private String mobile_no;
    private Long user_id;
}
