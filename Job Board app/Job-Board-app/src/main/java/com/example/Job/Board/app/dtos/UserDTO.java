package com.example.Job.Board.app.dtos;

import lombok.Data;

@Data
public class UserDTO {

    private Long user_id;
    private String username;
    private String password;
    private Long role_id;
}
