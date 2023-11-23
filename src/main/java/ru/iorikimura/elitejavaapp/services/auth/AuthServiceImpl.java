package ru.iorikimura.elitejavaapp.services.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.iorikimura.elitejavaapp.dao.UserDao;
import ru.iorikimura.elitejavaapp.dto.models.TokenModel;
import ru.iorikimura.elitejavaapp.dto.models.UserModel;
import ru.iorikimura.elitejavaapp.dto.request.LoginRequest;
import ru.iorikimura.elitejavaapp.dto.request.RegisterRequest;
import ru.iorikimura.elitejavaapp.dto.response.LoginResponse;
import ru.iorikimura.elitejavaapp.services.security.jwt.JwtService;

import javax.security.auth.login.CredentialException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserDao userDao;

    private final JwtService jwtService;

    @Override
    public UserModel register(RegisterRequest request) {
        if (userDao.getUserByEmail(request.getEmail()) != null){
            throw new RuntimeException("This email is already taken");
        }

        UserModel newUser = UserModel.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .build();

        return userDao.registerUser(newUser, request.getPassword());
    }

    @Override
    public LoginResponse login(LoginRequest request, HttpServletRequest servletRequest, HttpServletResponse httpServletResponse) throws CredentialException {
        if (!userDao.validateUser(request.getEmail(), request.getPassword())){
            throw new CredentialException("Wrong password!");
        }

        UserModel user = userDao.getUserByEmail(request.getEmail());

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword(), user.getAuthorities());

        SecurityContext context = SecurityContextHolder.createEmptyContext();

        context.setAuthentication(token);

        SecurityContextHolder.setContext(context);

        String userJwt = jwtService.generateToken(user);

        return LoginResponse.builder()
                .email(user.getEmail())
                .token(
                        TokenModel.builder()
                                .email(user.getEmail())
                                .token(userJwt)
                                .build()
                )
                .build();
    }
}
