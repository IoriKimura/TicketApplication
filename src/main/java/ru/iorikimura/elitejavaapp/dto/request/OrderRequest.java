package ru.iorikimura.elitejavaapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private String email;
    private String eventName;
    private String ticketType;
    private int price;
}
