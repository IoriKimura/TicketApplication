package ru.iorikimura.elitejavaapp.controllers.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iorikimura.elitejavaapp.dto.models.TicketModel;
import ru.iorikimura.elitejavaapp.dto.request.UserTicketRequest;
import ru.iorikimura.elitejavaapp.dto.response.UserTicketResponse;
import ru.iorikimura.elitejavaapp.services.ticket.TicketService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tickets")
public class TicketController {

    private final TicketService ticketService;
    @GetMapping("")
    public UserTicketResponse ticketsForEvent(@RequestBody UserTicketRequest request){
        List<TicketModel> ticketsForEvent = ticketService.findTicketForEvent(request);
        return UserTicketResponse.builder()
                .email(request.getEmail())
                .tickets(ticketsForEvent)
                .build();
    }
}
