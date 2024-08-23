package repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username);
}


