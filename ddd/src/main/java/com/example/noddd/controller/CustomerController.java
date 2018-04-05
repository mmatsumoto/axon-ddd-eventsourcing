package com.example.noddd.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.noddd.controller.dto.representation.CustomerRepresentation;
import com.example.noddd.controller.dto.request.CustomerRequest;
import com.example.noddd.domain.dto.CustomerAddressData;
import com.example.noddd.domain.dto.CustomerContactData;
import com.example.noddd.domain.dto.CustomerData;
import com.example.noddd.service.CustomerService;

/**
 * Created by mmatsumoto on 4/16/17
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(final CustomerService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerRepresentation create(@RequestBody CustomerRequest customerRequest) {

        CustomerData customerData = buildFromRequest(customerRequest).build();

        CustomerData customerCreated = service.saveOrUpdate(customerData);

        return CustomerRepresentation.of(customerCreated);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(path = "{id}")
    public CustomerRepresentation update(@PathVariable String id,
                                         @RequestBody CustomerRequest customerRequest) {

        service.findOne(id)
               .orElseThrow(NotFoundException::new);

        CustomerData customerData = buildFromRequest(customerRequest)
                                        .id(id)
                                        .build();

        CustomerData customerUpdated = service.saveOrUpdate(customerData);

        return CustomerRepresentation.of(customerUpdated);
    }

    private CustomerData.CustomerDataBuilder buildFromRequest(CustomerRequest request) {
        return CustomerData.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .birthday(request.getBirthday())
                .contacts(request.getContacts().stream().map(CustomerContactData::of).collect(Collectors.toSet()))
                .addresses(request.getAddresses().stream().map(CustomerAddressData::of).collect(Collectors.toSet()));
    }

}
