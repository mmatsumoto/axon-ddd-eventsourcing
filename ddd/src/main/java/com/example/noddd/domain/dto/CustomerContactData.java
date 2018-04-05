package com.example.noddd.domain.dto;

import com.example.noddd.controller.dto.request.CustomerContactRequest;
import com.example.noddd.domain.CustomerContact;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mmatsumoto on 4/16/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerContactData {
    private String id;
    private String email;
    private String mobileTelephone;
    private String homeTelephone;
    private Boolean main;

    public static CustomerContactData of(CustomerContactRequest request) {
        return CustomerContactData.builder()
                .id(request.getId())
                .email(request.getEmail())
                .mobileTelephone(request.getMobileTelephone())
                .homeTelephone(request.getHomeTelephone())
                .main(request.getMain())
                .build();
    }

    public static CustomerContactData of(CustomerContact contact) {
        return CustomerContactData.builder()
                .id(contact.getId())
                .email(contact.getEmail())
                .mobileTelephone(contact.getMobileTelephone())
                .homeTelephone(contact.getHomeTelephone())
                .main(contact.getMain())
                .build();
    }
}
