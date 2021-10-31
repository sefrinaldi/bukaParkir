package com.bukaParkir.module.user.payload;

import lombok.Data;

@Data
public class AuthResponse {
    private String email;
    private String password;
    private String name;
    private String token;
}
