package restcontrollers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositories.BookingRepository;
import entities.Booking;
@RestController
public class RestBookingController {
	@Autowired
	BookingRepository repository;
	@RequestMapping("/bookings")
	Collection<Booking> bookings(){
		return this.repository.findAll();
	}
}
