package com.example.noddd.controller.dto.representation;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.noddd.domain.Gender;
import com.example.noddd.domain.dto.CustomerData;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mmatsumoto on 4/16/17
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerRepresentation {
    private static final long serialVersionUID = -1877783150317749356L;

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private LocalDateTime birthday;
    private Set<CustomerContactRepresentation> contacts;
    private Set<CustomerAddressRepresentation> addresses;

    public static CustomerRepresentation of(CustomerData dto) {
        return CustomerRepresentation.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .middleName(dto.getMiddleName())
                .lastName(dto.getLastName())
                .gender(dto.getGender())
                .birthday(dto.getBirthday())
                .contacts(dto.getContacts().stream().map(CustomerContactRepresentation::of).collect(Collectors.toSet()))
                .addresses(dto.getAddresses().stream().map(CustomerAddressRepresentation::of).collect(Collectors.toSet()))
                .build();
    }
}
