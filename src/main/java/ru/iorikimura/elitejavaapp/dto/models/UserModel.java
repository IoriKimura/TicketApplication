package ru.iorikimura.elitejavaapp.dto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.iorikimura.elitejavaapp.entities.UserEntity;
import ru.iorikimura.elitejavaapp.enums.UserRole;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private LocalDate birthDate;

    private UserRole userRole;

    public static UserModel fromEntity(UserEntity user){
        return UserModel.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .userRole(user.getRole())
                .password(user.getPassword())
                .build();
    }
}
