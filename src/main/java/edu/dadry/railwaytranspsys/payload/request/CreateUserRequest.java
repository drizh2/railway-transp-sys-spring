package edu.dadry.railwaytranspsys.payload.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
}
