package com.anderson.spring_security.controller.dtos.request;

import com.anderson.spring_security.domain.model.User;
import com.anderson.spring_security.domain.model.enums.UserRoles;

public record UserRequestDTO(String name, String email, String password, UserRoles roles) {

    public static User from(UserRequestDTO request) {
        return User.builder()
                .name(request.name())
                .email(request.email)
                .password(request.password)
                .role(request.roles)
                .build();
    }
}
