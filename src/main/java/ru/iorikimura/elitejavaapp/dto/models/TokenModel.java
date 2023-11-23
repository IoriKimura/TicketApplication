package ru.iorikimura.elitejavaapp.dto.models;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenModel {

    private String email;

    private String token;
}
