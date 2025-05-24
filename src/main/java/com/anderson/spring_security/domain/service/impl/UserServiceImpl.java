package com.anderson.spring_security.domain.service.impl;

import com.anderson.spring_security.domain.model.User;
import com.anderson.spring_security.domain.service.IPasswordEncoderService;
import com.anderson.spring_security.domain.service.IUserService;
import com.anderson.spring_security.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;
    private final IPasswordEncoderService passwordEncoderService;


    @Override
    public User save(User user) {
        final String hash = passwordEncoderService.encode(user.getPassword());
        user.setPassword(hash);

        return repository.save(user);
    }
}
