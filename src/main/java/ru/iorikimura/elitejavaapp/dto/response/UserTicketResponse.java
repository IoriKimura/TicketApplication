package ru.iorikimura.elitejavaapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.iorikimura.elitejavaapp.dto.models.TicketModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTicketResponse {

    private String email;

    private List<TicketModel> tickets;
}

