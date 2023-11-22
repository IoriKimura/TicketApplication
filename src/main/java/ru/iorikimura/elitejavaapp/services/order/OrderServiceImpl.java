package ru.iorikimura.elitejavaapp.services.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.iorikimura.elitejavaapp.dao.EventDao;
import ru.iorikimura.elitejavaapp.dao.OrderDao;
import ru.iorikimura.elitejavaapp.dao.TicketDao;
import ru.iorikimura.elitejavaapp.dao.UserDao;
import ru.iorikimura.elitejavaapp.dto.models.OrderModel;
import ru.iorikimura.elitejavaapp.dto.request.OrderRequest;
import ru.iorikimura.elitejavaapp.entities.EventEntity;
import ru.iorikimura.elitejavaapp.entities.OrderEntity;
import ru.iorikimura.elitejavaapp.entities.TicketEntity;
import ru.iorikimura.elitejavaapp.entities.UserEntity;
import ru.iorikimura.elitejavaapp.enums.PaymentStatus;
import ru.iorikimura.elitejavaapp.enums.TicketType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderDao orderDao;
    private final UserDao userDao;
    private final EventDao eventDao;
    private final TicketDao ticketDao;

    @Override
    public OrderModel createOrder(OrderRequest request) {
        UserEntity user = userDao.getUserEntityByEmail(request.getEmail());

        EventEntity event = eventDao.getEventFromName(request.getEventName());

        TicketEntity ticket = TicketEntity.builder()
                .owner(user)
                .event(event)
                .ticketType(TicketType.valueOf(request.getTicketType()))
                .price(request.getPrice())
                .isRedeemed(false)
                .build();

        ticket = ticketDao.createTicket(ticket);

        OrderEntity order = OrderEntity.builder()
                .owner(user)
                .ticket(ticket)
                .paymentStatus(PaymentStatus.CREATED)
                .build();

        return orderDao.createOrder(order, ticket);
    }

    @Override
    public List<OrderModel> getOrders() {
        return orderDao.getOrders();
    }
}
