package com.bukaParkir.service;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.module.user.payload.RoleRequestDto;

public interface RoleService {

    BaseResponse addRole(RoleRequestDto roleRequestDto);
}
