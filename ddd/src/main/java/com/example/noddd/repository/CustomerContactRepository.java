package com.example.noddd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.noddd.domain.CustomerContact;

/**
 * Created by mmatsumoto on 4/16/17
 */
public interface CustomerContactRepository extends JpaRepository<CustomerContact, String> {
}
