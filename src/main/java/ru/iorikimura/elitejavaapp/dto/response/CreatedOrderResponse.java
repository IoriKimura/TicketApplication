package ru.iorikimura.elitejavaapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedOrderResponse {

    private String ticketId;
    private String paymentStatus;
}
