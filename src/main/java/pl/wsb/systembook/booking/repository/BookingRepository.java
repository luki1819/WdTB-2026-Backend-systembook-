package pl.wsb.systembook.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.systembook.booking.entity.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoom_Name(String name);
}