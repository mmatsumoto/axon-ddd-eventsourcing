package com.example.noddd.service;

import java.util.Optional;

import com.example.noddd.domain.dto.CustomerData;

/**
 * Created by mmatsumoto on 4/16/17
 */
public interface CustomerService {
    CustomerData saveOrUpdate(CustomerData customerData);
    Optional<CustomerData> findOne(String id);
}
