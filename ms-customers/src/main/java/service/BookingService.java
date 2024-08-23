package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Booking;
import repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    
    public Booking bookRoom(Long customerId, Long roomId) {
        if (customerId == null || roomId == null) {
            throw new IllegalArgumentException("Customer ID and room ID are required");
        }

        

        Booking booking = new Booking();
        booking.setCustomerId(customerId);
        booking.setRoomId(roomId);
        booking.setBookingDate(LocalDate.now());

        try {
            return bookingRepository.save(booking);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save booking", e);
        }
    }

    public List<Booking> viewBookings(Long customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID is required");
        }

        return bookingRepository.findByCustomerId(customerId);
    }
}