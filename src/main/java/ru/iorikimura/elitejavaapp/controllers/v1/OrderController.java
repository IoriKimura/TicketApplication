package ru.iorikimura.elitejavaapp.controllers.v1;

import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iorikimura.elitejavaapp.dto.models.OrderModel;
import ru.iorikimura.elitejavaapp.dto.request.OrderRequest;
import ru.iorikimura.elitejavaapp.dto.response.CreatedOrderResponse;
import ru.iorikimura.elitejavaapp.services.order.OrderService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderService orderService;
    @PostMapping("")
    public CreatedOrderResponse createOrder(@RequestBody OrderRequest request){
        OrderModel orderModel = orderService.createOrder(request);
        return CreatedOrderResponse.builder()
                .paymentStatus(orderModel.getPaymentStatus().name())
                .orderId(orderModel.getOrderId())
                .build();
    }
}
