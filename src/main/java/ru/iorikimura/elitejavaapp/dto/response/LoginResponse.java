package ru.iorikimura.elitejavaapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.iorikimura.elitejavaapp.dto.models.TokenModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    private String email;

    private TokenModel token;
}
