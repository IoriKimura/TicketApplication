package ru.iorikimura.elitejavaapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.iorikimura.elitejavaapp.dto.models.TicketModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketResponse {

    private TicketModel ticket;
}
