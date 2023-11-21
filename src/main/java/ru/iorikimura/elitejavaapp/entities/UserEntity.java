package ru.iorikimura.elitejavaapp.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;
import ru.iorikimura.elitejavaapp.enums.TypeReg;
import ru.iorikimura.elitejavaapp.enums.UserRole;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private TypeReg regType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "registration_date")
    private Date regDate;

    @Column(name = "last_action")
    private Date lastAction;

    @Column(name = "is_email_confirmed")
    private Boolean isEmailConfirmed;

}
