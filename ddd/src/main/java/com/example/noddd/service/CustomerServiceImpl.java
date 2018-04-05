package com.example.noddd.service;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.noddd.controller.NotFoundException;
import com.example.noddd.domain.Customer;
import com.example.noddd.domain.CustomerAddress;
import com.example.noddd.domain.CustomerContact;
import com.example.noddd.domain.dto.CustomerData;
import com.example.noddd.repository.CustomerRepository;

/**
 * Created by mmatsumoto on 4/16/17
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerData saveOrUpdate(CustomerData customerData) {
        Assert.notNull(customerData, "customerData cant be null");

        Customer customer;
        if (isEmpty(customerData.getId())) {
            customer = Customer.builder()
                    .id(UUID.randomUUID().toString())
                    .build();
        } else {
            customer = repository.findOne(customerData.getId());
            Optional.ofNullable(customer)
                    .orElseThrow(NotFoundException::new);
        }

        customer.setFirstName(customerData.getFirstName());
        customer.setMiddleName(customerData.getMiddleName());
        customer.setLastName(customerData.getLastName());
        customer.setBirthday(customerData.getBirthday());
        customer.setGender(customerData.getGender());

        Set<CustomerContact> contacts = customerData.getContacts().stream()
                .map(data ->
                        new CustomerContact(
                                data.getId(),
                                data.getMobileTelephone(),
                                data.getHomeTelephone(),
                                data.getEmail(),
                                data.getMain(),
                                customer))
                .collect(Collectors.toSet());

        if (contacts.stream().filter(CustomerContact::isMain).count() != 1) {
            throw new IllegalArgumentException("Only one contact can be configured as primary");
        }
        customer.setContacts(contacts);

        Set<CustomerAddress> addresses = customerData.getAddresses().stream()
                .map(data ->
                        new CustomerAddress(
                                data.getId(),
                                data.getStreet(),
                                data.getNumber(),
                                data.getZipCode(),
                                data.getNeighborhood(),
                                data.getDelivery(),
                                customer))
                .collect(Collectors.toSet());

        if (addresses.stream().filter(CustomerAddress::getDelivery).count() > 1) {
            throw new IllegalArgumentException("More than one address configured as delivery");
        }
        customer.setAddresses(addresses);

        return CustomerData.of(
                repository.save(customer) );
    }

    @Override
    public Optional<CustomerData> findOne(String id) {
        return Optional.ofNullable(repository.findOne(id))
                .map(CustomerData::of);
    }
}
