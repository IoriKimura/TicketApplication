package ru.iorikimura.elitejavaapp.controllers.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iorikimura.elitejavaapp.dto.request.OrderRequest;
import ru.iorikimura.elitejavaapp.dto.response.CreatedOrderResponse;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/v1/order")
public class OrderController {
    @PostMapping("")
    public CreatedOrderResponse createOrder(@RequestBody OrderRequest request){
//        CreatedOrderResponse response = new CreatedOrderResponse();
//        response.setTicketId(UUID.randomUUID().toString());
//        response.setPaymentStatus("CREATED");
//        return response;
        return null;
    }
}
