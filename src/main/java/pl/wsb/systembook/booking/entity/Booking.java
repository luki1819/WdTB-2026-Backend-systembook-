package pl.wsb.systembook.booking.entity;

import jakarta.persistence.*;
import pl.wsb.systembook.client.entity.Client;
import pl.wsb.systembook.room.entity.ConferenceRoom;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private BookingStatus status;

    @Column(name = "attendees", nullable = false)
    private Integer attendees;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Embedded
    private TimeSlot timeSlot;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private ConferenceRoom room;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    protected Booking() {
    }

    public Booking(String title, BookingStatus status, Integer attendees,
                   LocalDateTime createdAt, TimeSlot timeSlot,
                   ConferenceRoom room, Client client) {
        this.title = title;
        this.status = status;
        this.attendees = attendees;
        this.createdAt = createdAt;
        this.timeSlot = timeSlot;
        this.room = room;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Integer getAttendees() {
        return attendees;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public ConferenceRoom getRoom() {
        return room;
    }

    public Client getClient() {
        return client;
    }
}