package com.example.noddd.controller.dto.request;

import java.time.LocalDateTime;
import java.util.Set;

import com.example.noddd.domain.Gender;

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
public class CustomerRequest {
    private static final long serialVersionUID = 7992024557445200744L;

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private LocalDateTime birthday;
    private Set<CustomerContactRequest> contacts;
    private Set<CustomerAddressRequest> addresses;
}
