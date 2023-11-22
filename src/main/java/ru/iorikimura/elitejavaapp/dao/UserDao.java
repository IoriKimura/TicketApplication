package ru.iorikimura.elitejavaapp.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.iorikimura.elitejavaapp.dto.models.UserModel;
import ru.iorikimura.elitejavaapp.entities.UserEntity;
import ru.iorikimura.elitejavaapp.repositories.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final UserRepository userRepo;

    public UserModel getUserByEmail(String email){
        if(userRepo.findByEmail(email).isPresent()){
            return UserModel.fromEntity(userRepo.findByEmail(email).get());
        }
        return null;
    }

    public List<UserEntity> getAllUsers(){
        return userRepo.findAll();
    }

    public UserEntity getUserEntityByEmail(String email){
        return userRepo.findByEmail(email).orElseThrow();
    }

//    public UserModel registerUser(UserModel userModel, String password){
//        UserEntity user = UserEntity.builder()
//                .email(userModel.getEmail())
//                .password(passwordEncoder.encode(password))
//                .firstName(userModel.getFirstName())
//                .lastName(userModel.getLastName())
//                .birthDate(userModel.getBirthDate())
//                .role(UserRole.USER)
//                .regType(TypeReg.APP)
//                .registrationDate(LocalDateTime.now())
//                .lastAction(LocalDateTime.now())
//                .emailIsConfirmed(false)
//                .build();
//        return UserModel.fromEntity(userRepository.save(user));
//    }

//    public boolean validateUser(String email, String password){
//        UserEntity user = getUserEntityByEmail(email);
//
//        return passwordEncoder.matches(password, user.getPassword());
//    }

    public boolean userExistByEmail(String email){
        return userRepo.findByEmail(email).isPresent();
    }
}
