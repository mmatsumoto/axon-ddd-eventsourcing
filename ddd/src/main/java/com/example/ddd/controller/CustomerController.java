package com.example.ddd.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ddd.controller.dto.ChangeCustomerAddress;
import com.example.ddd.controller.dto.ChangeCustomerEmail;
import com.example.ddd.controller.dto.ChangeCustomerHomeTelephone;
import com.example.ddd.controller.dto.CreateCustomerRequest;
import com.example.ddd.domain.customer.CustomerId;
import com.example.ddd.service.CustomerCommandService;
import com.example.noddd.controller.dto.representation.CustomerRepresentation;
import com.example.noddd.domain.dto.CustomerData;

/**
 * Created by mmatsumoto on 4/17/17
 */
@RestController
@RequestMapping("/v2/customers")
public class CustomerController {

    private CustomerCommandService commandService;

    @Autowired
    public CustomerController(CustomerCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public CustomerRepresentation createCustomer(@Valid @RequestBody CreateCustomerRequest request) {
        CustomerData customerData = commandService.createCustomer(
                request.getFirstName(),
                request.getMiddleName(),
                request.getLastName(),
                request.getContact());

        return CustomerRepresentation.of(customerData);
    }

    @PutMapping(path = "{customerId}/email", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public CustomerRepresentation changePersonalEmail(
            @PathVariable CustomerId customerId,
            @Valid @RequestBody ChangeCustomerEmail request) {

        CustomerData customerData =  commandService
                .changePersonalEmail(customerId, request.getEmail());

        return CustomerRepresentation.of(customerData);
    }

    @PutMapping(path = "{customerId}/changeHomeTelephone", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public CustomerRepresentation changePersonalEmail(
            @PathVariable CustomerId customerId,
            @Valid @RequestBody ChangeCustomerHomeTelephone request) {

        CustomerData customerData =  commandService
                .changeHomeTelephone(customerId, request.getHomeTelephone());

        return CustomerRepresentation.of(customerData);
    }

    @PutMapping(path = "{customerId}/changeHomeTelephone", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public CustomerRepresentation realocateTo(
            @PathVariable CustomerId customerId,
            @Valid @RequestBody ChangeCustomerAddress request) {

        CustomerData customerData =  commandService
                .realocateTo(customerId, request.getAddress());

        return CustomerRepresentation.of(customerData);
    }

}
