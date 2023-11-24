package ru.iorikimura.elitejavaapp.services.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.iorikimura.elitejavaapp.dao.TicketDao;
import ru.iorikimura.elitejavaapp.dto.models.TicketModel;
import ru.iorikimura.elitejavaapp.dto.request.UserTicketRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{

    private final TicketDao ticketDao;
    @Override
    public List<TicketModel> findTicketForEvent(UserTicketRequest request) {
        return ticketDao.getTicketForEvent(request.getEmail(), request.getEventName());
    }
}
