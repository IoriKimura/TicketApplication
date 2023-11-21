package ru.iorikimura.elitejavaapp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import ru.iorikimura.elitejavaapp.enums.TicketType;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    private UserEntity owner;

    @ManyToOne
    private EventEntity event;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @Column(name = "ticket_price")
    private Integer price;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "is_redeemed")
    private boolean isRedeemed;
}
