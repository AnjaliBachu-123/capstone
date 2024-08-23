package repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerId(Long customerId);
}


