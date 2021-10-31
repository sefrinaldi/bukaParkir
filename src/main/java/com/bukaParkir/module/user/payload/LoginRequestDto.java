package com.bukaParkir.module.user.payload;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
