package com.example.ddd.controller.dto;

import javax.validation.constraints.NotNull;

import com.example.ddd.domain.customer.contact.HomeTelephone;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/18/17
 */
@Getter
@AllArgsConstructor
public class ChangeCustomerHomeTelephone {
    @NotNull
    private final HomeTelephone homeTelephone;
}
