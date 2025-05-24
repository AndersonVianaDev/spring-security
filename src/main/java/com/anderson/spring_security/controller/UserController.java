package com.anderson.spring_security.controller;

import com.anderson.spring_security.controller.dtos.request.UserRequestDTO;
import com.anderson.spring_security.controller.dtos.response.UserResponseDTO;
import com.anderson.spring_security.domain.model.User;
import com.anderson.spring_security.domain.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO request) {
        User user = service.save(UserRequestDTO.from(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDTO.of(user));
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("Administrator permission only");
    }

    @GetMapping("/")
    public ResponseEntity<String> authenticated() {
        return ResponseEntity.ok("authenticated");
    }
}
