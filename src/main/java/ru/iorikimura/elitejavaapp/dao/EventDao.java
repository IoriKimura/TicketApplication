package ru.iorikimura.elitejavaapp.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.iorikimura.elitejavaapp.entities.EventEntity;
import ru.iorikimura.elitejavaapp.repositories.EventRepository;

@Component
@RequiredArgsConstructor
public class EventDao {

    private final EventRepository eventRepo;

    // Поиск события по имени в БД
    public EventEntity getEventFromName(String eventName){
        return eventRepo.findByEventName(eventName).orElseThrow();
    }

    // Изменение информации о событии
//    public void updateEventDateTime(ChangeEventDateTimeRequest request){
//        eventRepo.updateEventDateTime(request.getEventDate(),
//                request.getEventTime(),
//                request.getEventName());
//    }

}
