package com.example.noddd.controller.dto.representation;

import com.example.noddd.domain.dto.CustomerContactData;

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
public class CustomerContactRepresentation {
    private String id;
    private String email;
    private String mobileTelephone;
    private String homeTelephone;
    private Boolean main;

    public static CustomerContactRepresentation of(CustomerContactData data) {
        return CustomerContactRepresentation.builder()
                .id(data.getId())
                .email(data.getEmail())
                .mobileTelephone(data.getMobileTelephone())
                .homeTelephone(data.getHomeTelephone())
                .main(data.getMain())
                .build();
    }
}
