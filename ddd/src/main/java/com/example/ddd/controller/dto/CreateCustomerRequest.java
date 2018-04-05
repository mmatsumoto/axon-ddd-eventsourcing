package com.example.ddd.controller.dto;

import javax.validation.constraints.NotNull;

import com.example.ddd.domain.customer.contact.Contact;
import com.example.ddd.domain.customer.personal.FirstName;
import com.example.ddd.domain.customer.personal.LastName;
import com.example.ddd.domain.customer.personal.MiddleName;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by mmatsumoto on 4/17/17
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateCustomerRequest {

    @NotNull
    private FirstName firstName;
    private MiddleName middleName;
    @NotNull
    private LastName lastName;
    @NotNull
    private Contact contact;

}
