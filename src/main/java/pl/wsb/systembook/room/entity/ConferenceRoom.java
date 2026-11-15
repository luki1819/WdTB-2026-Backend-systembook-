package pl.wsb.systembook.room.entity;

import jakarta.persistence.*;
import pl.wsb.systembook.booking.entity.Booking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conference_room")
public class ConferenceRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 60)
    private String name;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "floor_number", nullable = false)
    private Integer floorNumber;

    @Column(name = "hourly_rate", nullable = false, precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    @Column(name = "has_projector", nullable = false)
    private Boolean hasProjector;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings = new ArrayList<>();

    protected ConferenceRoom() {
    }

    public ConferenceRoom(String name, Integer capacity, Integer floorNumber,
                          BigDecimal hourlyRate, Boolean hasProjector) {
        this.name = name;
        this.capacity = capacity;
        this.floorNumber = floorNumber;
        this.hourlyRate = hourlyRate;
        this.hasProjector = hasProjector;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public Boolean getHasProjector() {
        return hasProjector;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}