package ru.iorikimura.elitejavaapp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;
import ru.iorikimura.elitejavaapp.enums.TicketType;

import java.util.Date;
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

    @Column
    private Integer price;

    // В чём разница между Date SQL и Date Until
    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "is_redeemed")
    private Boolean isRedeemed;
}
