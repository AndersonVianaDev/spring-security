package com.anderson.spring_security.controller.dtos.response;

import com.anderson.spring_security.domain.model.User;
import com.anderson.spring_security.domain.model.enums.UserRoles;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, UserRoles role) {

    public static UserResponseDTO of (User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
}
