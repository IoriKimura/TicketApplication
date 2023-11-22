package ru.iorikimura.elitejavaapp.dto.models;

import lombok.*;
import ru.iorikimura.elitejavaapp.entities.EventEntity;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventModel {

    private String eventName;

    private LocalDate eventDate;

    private LocalTime eventTime;

    private String eventPlace;

    private String eventMinAge;

    private boolean isActive;

    public static EventModel fromEntity(EventEntity eventEntity){
        return EventModel.builder()
                .eventName(eventEntity.getEventName())
                .eventDate(eventEntity.getEventDate())
                .eventTime(eventEntity.getEventTime())
                .eventPlace(eventEntity.getEventPlace())
                .eventMinAge(eventEntity.getEventMinAge())
                .isActive(eventEntity.isActive())
                .build();
    }
}
