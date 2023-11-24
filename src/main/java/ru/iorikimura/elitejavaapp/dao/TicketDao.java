package ru.iorikimura.elitejavaapp.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.iorikimura.elitejavaapp.dto.models.TicketModel;
import ru.iorikimura.elitejavaapp.entities.TicketEntity;
import ru.iorikimura.elitejavaapp.repositories.TicketRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketDao {

    private final TicketRepository ticketRepo;


    public TicketEntity createTicket(TicketEntity ticket) {
        return ticketRepo.save(ticket);
    }

    public List<TicketModel> getAllTicketsByUser(String email){
        return ticketRepo.findTicketsByEmail(email).stream().map(TicketModel::fromEntity).toList();
    }

    public List<TicketEntity> getAllTicketEntitiesByUser(String email){
        return ticketRepo.findTicketsByEmail(email);
    }

    public List<TicketModel> getTicketForEvent(String email, String eventName){
        return ticketRepo.findTicketsForEvent(email, eventName).stream().map(TicketModel::fromEntity).toList();
    }
}
