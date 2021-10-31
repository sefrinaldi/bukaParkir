package com.bukaParkir.service.impl;

import com.bukaParkir.common.payload.BaseResponse;
import com.bukaParkir.common.payload.CommonMessage;
import com.bukaParkir.model.Role;
import com.bukaParkir.model.User;
import com.bukaParkir.module.user.payload.AuthResponse;
import com.bukaParkir.module.user.payload.LoginRequestDto;
import com.bukaParkir.module.user.payload.UserRequestDto;
import com.bukaParkir.repository.RoleRepository;
import com.bukaParkir.repository.UserRepository;
import com.bukaParkir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public BaseResponse addUser(UserRequestDto userRequestDto) {
        try {
            String emailRgx = "^([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
            String passwordRgx = "^[a-zA-Z0-9@\\\\#$%&*()_+\\]\\[';:?.,!^-]{8,}$";

            boolean emailTrue = Pattern.matches(emailRgx, userRequestDto.getEmail());
            boolean passwordTrue = Pattern.matches(passwordRgx, userRequestDto.getPassword());
            if (emailTrue && passwordTrue) {
                User user = new User();
                user.setName(userRequestDto.getName());
                user.setEmail(userRequestDto.getEmail());
                user.setPassword(userRequestDto.getPassword());
                Optional<Role> role = roleRepository.findById(userRequestDto.getRole());
                user.setRole(role.get());
                user.setIsActive(0);
                userRepository.save(user);
                return new BaseResponse(CommonMessage.REGISTER_SUCCESS, 200, user);
            } else {
                return new BaseResponse(CommonMessage.REGISTER_ERROR, 400);
            }

        } catch (Exception e) {
            return new BaseResponse(CommonMessage.REGISTER_ERROR, 400);
        }
    }

    @Override
    public BaseResponse getAll() {
        try {
            List<User> users = userRepository.findAll();
            return new BaseResponse(CommonMessage.FOUND, 200, users);

        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_FOUND, 400);
        }
    }

    @Override
    public BaseResponse updateUser(Long id, UserRequestDto userRequestDto) {
        try {

            User user = userRepository.findById(id).get();
            System.out.println(user.getId());

            Role role = roleRepository.findById(userRequestDto.getRole()).get();
//                  .orElseThrow(() -> new RuntimeException(CommonMessage.NOT_FOUND + id));

            user.setName(userRequestDto.getName());
            user.setEmail(userRequestDto.getEmail());
            user.setPassword(userRequestDto.getPassword());
            user.setRole(role);
            user.setIsActive(userRequestDto.getIsActive());

            userRepository.save(user);
            return new BaseResponse(CommonMessage.UPDATED, 200, user);

        } catch (Exception e) {
            return new BaseResponse(CommonMessage.NOT_UPDATED, 400);

        }
    }

    @Override
    public BaseResponse deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(CommonMessage.NOT_FOUND + id));
        user.setIsActive(1);
        userRepository.save(user);
        return new BaseResponse(CommonMessage.DELETED, 200, user);

    }

    @Override
    public BaseResponse login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail());

        if (user == null) {
            return new BaseResponse(CommonMessage.NOT_FOUND, 400);
        } else if (user.getEmail().equals(loginRequestDto.getEmail()) && user.getPassword().equals(loginRequestDto.getPassword())) {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setEmail(user.getEmail());
            authResponse.setName(user.getName());
            return new BaseResponse(CommonMessage.LOGIN_SUCCESS, 200, authResponse.getEmail());
        } else {
            return new BaseResponse(CommonMessage.LOGIN_ERROR, 400);
        }
    }


}
