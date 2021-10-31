package com.bukaParkir.module.user.controller;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.module.user.payload.LoginRequestDto;
import com.bukaParkir.module.user.payload.RoleRequestDto;
import com.bukaParkir.module.user.payload.UserRequestDto;
import com.bukaParkir.service.RoleService;
import com.bukaParkir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @PostMapping("/add-role")
    public BaseResponse addRole(@RequestBody RoleRequestDto roleRequestDto){
        return roleService.addRole(roleRequestDto);
    }

    @PostMapping("/add-user")
    public BaseResponse addUser(@RequestBody UserRequestDto userRequestDto){
        return userService.addUser(userRequestDto);
    }

    @GetMapping("/")
    public BaseResponse getAll(){
        return userService.getAll();
    }

    @PostMapping("/update-user/{id}")
    public BaseResponse updateUser(@PathVariable("id") Long id, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(id, userRequestDto);
    }

    @PostMapping("/delete-user/{id}")
    public BaseResponse deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

    @PostMapping("/login")
    public BaseResponse login(@RequestBody LoginRequestDto loginRequestDto){
        return userService.login(loginRequestDto);
    }
}
