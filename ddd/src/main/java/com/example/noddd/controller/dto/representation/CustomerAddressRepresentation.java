package com.example.noddd.controller.dto.representation;

import com.example.noddd.domain.dto.CustomerAddressData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mmatsumoto on 4/16/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAddressRepresentation {
    private String id;
    private String street;
    private Integer number;
    private String neighborhood;
    private String zipCode;
    private Boolean delivery;

    public static CustomerAddressRepresentation of(CustomerAddressData data) {
        return CustomerAddressRepresentation.builder()
                .id(data.getId())
                .street(data.getStreet())
                .number(data.getNumber())
                .neighborhood(data.getNeighborhood())
                .zipCode(data.getZipCode())
                .delivery(data.getDelivery())
                .build();
    }
}
