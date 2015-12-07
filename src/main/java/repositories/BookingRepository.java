package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	Collection<Booking> findByBookingName(String bookingName);
}
