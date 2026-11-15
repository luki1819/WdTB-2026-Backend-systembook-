package pl.wsb.systembook.booking.entity;

import jakarta.persistence.*;
import pl.wsb.systembook.amenity.entity.Amenity;

@Entity
@Table(name = "booking_amenity")
public class BookingAmenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "amenity_id", nullable = false)
    private Amenity amenity;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "note", length = 120)
    private String note;

    protected BookingAmenity() {
    }

    public BookingAmenity(Booking booking, Amenity amenity, Integer quantity, String note) {
        this.booking = booking;
        this.amenity = amenity;
        this.quantity = quantity;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public Booking getBooking() {
        return booking;
    }

    public Amenity getAmenity() {
        return amenity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getNote() {
        return note;
    }
}