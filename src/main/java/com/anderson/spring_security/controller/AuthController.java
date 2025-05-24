package com.anderson.spring_security.controller;

import com.anderson.spring_security.controller.dtos.request.LoginRequestDTO;
import com.anderson.spring_security.domain.model.User;
import com.anderson.spring_security.infra.security.token.ITokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {

    private final ITokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {
        final var usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        final User user = (User) authenticationManager.authenticate(usernamePassword).getPrincipal();
        final String token = tokenService.generate(user.getId());

        return ResponseEntity.ok(token);
    }

}
