package ru.iorikimura.elitejavaapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeEventDateTimeRequest {

    private String eventName;

    private LocalDate eventDate;

    private LocalTime eventTime;
}
