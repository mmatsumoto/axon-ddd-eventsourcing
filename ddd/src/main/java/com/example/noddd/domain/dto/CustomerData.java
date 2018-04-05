package com.example.noddd.domain.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.noddd.domain.Customer;
import com.example.noddd.domain.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mmatsumoto on 4/16/
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerData {
    private static final long serialVersionUID = 108999666691545847L;

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private LocalDateTime birthday;
    private Set<CustomerContactData> contacts;
    private Set<CustomerAddressData> addresses;

    public static CustomerData of(Customer customer) {
        return CustomerData.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName())
                .lastName(customer.getLastName())
                .gender(customer.getGender())
                .birthday(customer.getBirthday())
                .contacts(customer.getContacts().stream().map(CustomerContactData::of).collect(Collectors.toSet()))
                .addresses(customer.getAddresses().stream().map(CustomerAddressData::of).collect(Collectors.toSet()))
                .build();


    }

    public static CustomerData of(com.example.ddd.domain.customer.Customer customer) {
        //TODO
        return null;
    }
}
