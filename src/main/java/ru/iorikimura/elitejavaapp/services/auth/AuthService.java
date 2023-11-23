package ru.iorikimura.elitejavaapp.services.auth;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.iorikimura.elitejavaapp.dto.models.UserModel;
import ru.iorikimura.elitejavaapp.dto.request.LoginRequest;
import ru.iorikimura.elitejavaapp.dto.request.RegisterRequest;
import ru.iorikimura.elitejavaapp.dto.response.LoginResponse;

import javax.security.auth.login.CredentialException;

public interface AuthService {

    UserModel register(RegisterRequest request);

    LoginResponse login(LoginRequest request, HttpServletRequest servletRequest,
                        HttpServletResponse httpServletResponse) throws CredentialException;
}
