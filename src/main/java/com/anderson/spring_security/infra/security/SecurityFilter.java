package com.anderson.spring_security.infra.security;

import com.anderson.spring_security.domain.model.User;
import com.anderson.spring_security.infra.exceptions.NotFoundException;
import com.anderson.spring_security.infra.repository.UserRepository;
import com.anderson.spring_security.infra.security.token.ITokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final ITokenService tokenService;
    private final UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String token = recoverToken(request);

        if (nonNull(token)) {
            authenticate(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticate(String token) {
        UUID id = tokenService.extractID(token);
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));
        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


    private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (isNull(token) || !token.startsWith("Bearer ")) return null;
        return token.replace("Bearer ", "");
    }
}
