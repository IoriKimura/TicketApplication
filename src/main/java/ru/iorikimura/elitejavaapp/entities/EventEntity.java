package ru.iorikimura.elitejavaapp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_date")
    private Date eventDate;

    @Column(name = "event_time")
    private Time eventTime;

    @Column(name = "event_place")
    private String eventPlace;

    @Column(name = "event_min_age")
    private String eventMinAge;

    @Column(name = "is_active")
    private Boolean isActive;

}
