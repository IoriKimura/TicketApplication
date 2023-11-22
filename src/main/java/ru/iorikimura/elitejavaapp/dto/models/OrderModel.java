package ru.iorikimura.elitejavaapp.dto.models;

import lombok.*;
import ru.iorikimura.elitejavaapp.entities.OrderEntity;
import ru.iorikimura.elitejavaapp.enums.PaymentStatus;
import ru.iorikimura.elitejavaapp.enums.TicketType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderModel {

    private String orderId;

    private PaymentStatus paymentStatus;

    private TicketModel ticket;

    public static OrderModel fromEntity(OrderEntity orderEntity){
        return OrderModel.builder()
                .orderId(orderEntity.getId().toString())
                .paymentStatus(orderEntity.getPaymentStatus())
                .ticket(TicketModel.fromEntity(orderEntity.getTicket()))
                .build();
    }

}
