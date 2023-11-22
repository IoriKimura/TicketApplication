package ru.iorikimura.elitejavaapp.services.order;

import ru.iorikimura.elitejavaapp.dto.models.OrderModel;
import ru.iorikimura.elitejavaapp.dto.request.OrderRequest;

import java.util.List;

public interface OrderService {

    OrderModel createOrder(OrderRequest request);

    List<OrderModel> getOrders();
}
