package ru.iorikimura.elitejavaapp.services.security.jwt;

import org.springframework.stereotype.Service;
import ru.iorikimura.elitejavaapp.dto.models.UserModel;

public interface JwtService {

    UserModel parseToken(String jwtToken);

    String generateToken(UserModel user);
}
