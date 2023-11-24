package ru.iorikimura.elitejavaapp.services.ticket;

import ru.iorikimura.elitejavaapp.dto.models.TicketModel;
import ru.iorikimura.elitejavaapp.dto.request.UserTicketRequest;

import java.util.List;

public interface TicketService {

    List<TicketModel> findTicketForEvent(UserTicketRequest request);
}
