package ru.iorikimura.elitejavaapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "telegram_users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelegramUserEntity {

    @Id
    private Integer telegramId;

    @OneToOne
    private UserEntity user;
}
