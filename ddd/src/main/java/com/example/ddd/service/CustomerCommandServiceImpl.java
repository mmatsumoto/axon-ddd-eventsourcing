package com.example.ddd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ddd.domain.customer.Customer;
import com.example.ddd.domain.customer.CustomerId;
import com.example.ddd.domain.customer.CustomerRepository;
import com.example.ddd.domain.customer.address.Address;
import com.example.ddd.domain.customer.contact.Contact;
import com.example.ddd.domain.customer.contact.HomeTelephone;
import com.example.ddd.domain.customer.personal.Email;
import com.example.ddd.domain.customer.personal.FirstName;
import com.example.ddd.domain.customer.personal.LastName;
import com.example.ddd.domain.customer.personal.MiddleName;
import com.example.noddd.controller.NotFoundException;
import com.example.noddd.domain.dto.CustomerData;

/**
 * Created by mmatsumoto on 4/18/17
 */
@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerCommandServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public CustomerData createCustomer(FirstName firstName, MiddleName middleName, LastName lastName, Contact contact) {

        Customer customer = Customer.createCustomer(
                firstName,
                middleName,
                lastName,
                contact,
                repository);

        return CustomerData.of(customer);
    }

    @Transactional
    @Override
    public CustomerData changePersonalEmail(CustomerId customerId, Email changedEmail) {

        Customer existingCustomer = repository.findOne(customerId);
        if (existingCustomer == null) {
            throw new NotFoundException();
        }

        Customer customerEmailUpdated = existingCustomer
                .changePersonalEmail(changedEmail, repository);

        return CustomerData.of(customerEmailUpdated);
    }

    @Transactional
    @Override
    public CustomerData changeHomeTelephone(CustomerId customerId, HomeTelephone changedHomeTelephone) {
        Customer existingCustomer = repository.findOne(customerId);
        if (existingCustomer == null) {
            throw new NotFoundException();
        }

        Customer customerContactUpdated = existingCustomer
                .changeHomeTelephone(changedHomeTelephone, repository);

        return CustomerData.of(customerContactUpdated);
    }

    @Transactional
    @Override
    public CustomerData realocateTo(CustomerId customerId, Address changedAddress) {

        Customer existingCustomer = repository.findOne(customerId);
        if (existingCustomer == null) {
            throw new NotFoundException();
        }

        Customer customerRealocated = existingCustomer
                .realocateTo(changedAddress, repository);

        return CustomerData.of(customerRealocated);
    }
}
