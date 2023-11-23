package ru.iorikimura.elitejavaapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.iorikimura.elitejavaapp.dto.models.TicketModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DownloadTicketResponse {

    private TicketModel ticketModel;

    private String downloadUrl;
}
