package ru.iorikimura.elitejavaapp.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.iorikimura.elitejavaapp.dto.models.OrderModel;
import ru.iorikimura.elitejavaapp.dto.models.TicketModel;
import ru.iorikimura.elitejavaapp.entities.OrderEntity;
import ru.iorikimura.elitejavaapp.entities.TicketEntity;
import ru.iorikimura.elitejavaapp.repositories.OrderRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDao {

    private final OrderRepository orderRepo;

    // Добавление нового заказа в БД
    public OrderModel createOrder(OrderEntity orderEntity, TicketEntity ticket){
        OrderEntity order = orderRepo.save(orderEntity);
        return OrderModel.builder()
                .orderId(order.getId().toString())
                .ticket(TicketModel.fromEntity(order.getTicket()))
                .paymentStatus(order.getPaymentStatus())
                .build();
    }

    // Получение всех заказов из БД
    public List<OrderModel> getOrders(){
        return orderRepo.findAll().stream().map(OrderModel::fromEntity).toList();
    }
}
