package ru.iorikimura.elitejavaapp.controllers.v1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iorikimura.elitejavaapp.dto.models.UserModel;
import ru.iorikimura.elitejavaapp.dto.request.LoginRequest;
import ru.iorikimura.elitejavaapp.dto.request.RegisterRequest;
import ru.iorikimura.elitejavaapp.dto.response.LoginResponse;
import ru.iorikimura.elitejavaapp.services.auth.AuthService;

import javax.security.auth.login.CredentialException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public UserModel register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request,
                               HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws CredentialException{
        LoginResponse response = authService.login(request, httpServletRequest, httpServletResponse);
        httpServletResponse.addCookie(new Cookie("jwt", response.getToken().getToken()));
        return response;
    }
}
