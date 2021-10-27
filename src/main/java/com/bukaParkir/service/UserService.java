package com.bukaParkir.service;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.module.user.payload.LoginRequestDto;
import com.bukaParkir.module.user.payload.UserRequestDto;

public interface UserService {

    BaseResponse addUser(UserRequestDto userRequestDto);

    BaseResponse getAll();

    BaseResponse updateUser(Long id, UserRequestDto userRequestDto);

    BaseResponse deleteUser(Long id);

    BaseResponse login(LoginRequestDto loginRequestDto);
}
