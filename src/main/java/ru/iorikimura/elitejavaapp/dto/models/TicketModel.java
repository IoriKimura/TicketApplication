package ru.iorikimura.elitejavaapp.dto.models;

import lombok.*;
import ru.iorikimura.elitejavaapp.entities.TicketEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketModel {

    private UUID ticketId;

    private String eventName;

    private String ownerFirstName;

    private String ownerLastName;

    private int price;

    private LocalDateTime purchaseDate;

    private boolean isRedeemed;

    public static TicketModel fromEntity(TicketEntity ticket){
        return TicketModel.builder()
                .ticketId(ticket.getId())
                .eventName(ticket.getEvent().getEventName())
                .ownerFirstName(ticket.getOwner().getFirstName())
                .ownerLastName(ticket.getOwner().getLastName())
                .price(ticket.getPrice())
                .purchaseDate(ticket.getPurchaseDate())
                .isRedeemed(ticket.isRedeemed())
                .build();
    }
}
