package ru.iorikimura.elitejavaapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTicketRequest {

    private String email;

    private String eventName;
}

