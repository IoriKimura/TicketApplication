package ru.iorikimura.elitejavaapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.iorikimura.elitejavaapp.entities.EventEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface EventRepository extends JpaRepository<EventEntity, UUID> {
    Optional<EventEntity> findByEventName(String eventName);

    @Modifying
    @Query("""
            UPDATE EventEntity event
            SET event.eventDate = :eventDate,
                event.eventTime = :eventTime
            WHERE event.eventName = :eventName
            """)
    void updateEventDateTime(LocalDate eventDate, LocalTime eventTime, String eventName);
}
