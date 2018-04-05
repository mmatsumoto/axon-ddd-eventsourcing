package com.example.ddd.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mmatsumoto on 4/18/17
 */
public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
}
