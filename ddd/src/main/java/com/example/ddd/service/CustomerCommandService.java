package com.example.ddd.service;

import com.example.ddd.domain.customer.CustomerId;
import com.example.ddd.domain.customer.address.Address;
import com.example.ddd.domain.customer.contact.Contact;
import com.example.ddd.domain.customer.contact.HomeTelephone;
import com.example.ddd.domain.customer.personal.Email;
import com.example.ddd.domain.customer.personal.FirstName;
import com.example.ddd.domain.customer.personal.LastName;
import com.example.ddd.domain.customer.personal.MiddleName;
import com.example.noddd.domain.dto.CustomerData;

/**
 * Created by mmatsumoto on 4/18/17
 */
public interface CustomerCommandService {
    CustomerData createCustomer(FirstName firstName, MiddleName middleName, LastName lastName, Contact contact);

    CustomerData changePersonalEmail(CustomerId customerId, Email changedEmail);

    CustomerData changeHomeTelephone(CustomerId customerId, HomeTelephone changedHomeTelephone);

    CustomerData realocateTo(CustomerId customerId, Address changedAddress);
}
