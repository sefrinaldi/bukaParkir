package com.bukaParkir.service.impl;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.common.payload.CommonMessage;
import com.bukaParkir.model.Role;
import com.bukaParkir.module.user.payload.RoleRequestDto;
import com.bukaParkir.repository.RoleRepository;
import com.bukaParkir.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public BaseResponse addRole(RoleRequestDto roleRequestDto) {

        try {
            Role role = new Role();
            role.setName(roleRequestDto.getName());
            roleRepository.save(role);

            return new BaseResponse(CommonMessage.SAVED, 200, role);
        } catch (
                Exception e) {
            return new BaseResponse(CommonMessage.NOT_SAVED, 400);

        }
    }
}
