package ru.iorikimura.elitejavaapp.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.iorikimura.elitejavaapp.services.security.filter.JwtFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
// ToDo: Сделать JWTService, JWTFilter, UserDetails

    private final JwtFilter jwtFilter;
    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                // Отключение аутентификации по HTTP
                .httpBasic(AbstractHttpConfigurer::disable)
                // Отключение проверки CSRF токена
                .csrf(AbstractHttpConfigurer::disable)
                // Ставим политику сессий на STATELESS - отключаем хранение сессий
                .sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Настраиваем доступ к end-points
                .authorizeHttpRequests(config ->
                        config.requestMatchers("/v1/orders").authenticated()
                                .requestMatchers(HttpMethod.POST, "/v1/auth/**").permitAll()
                                .requestMatchers("/static/**").permitAll()
                                .anyRequest().authenticated()
                )
                // Отключаем логин через форму
                .formLogin(AbstractHttpConfigurer::disable)
                // Добавляем JWT Filter перед фильтром аутентификации по Username/Password
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                //.addFilterBefore(exceptionFilter, JwtFilter.class)
                // Инициализируем полученный объект политик и возвращаем из метода
                .build();
    }
}
