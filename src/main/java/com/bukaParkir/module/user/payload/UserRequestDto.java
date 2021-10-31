package com.bukaParkir.module.user.payload;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private Long role;
    private int isActive;
}
