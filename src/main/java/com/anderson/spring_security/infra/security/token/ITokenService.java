package com.anderson.spring_security.infra.security.token;

import java.util.UUID;

public interface ITokenService {
    String generate(UUID id);
    UUID extractID(String token);
}
