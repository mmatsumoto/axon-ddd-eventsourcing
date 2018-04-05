package com.example.noddd.domain.dto;

import com.example.noddd.controller.dto.request.CustomerAddressRequest;
import com.example.noddd.domain.CustomerAddress;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mmatsumoto on 4/16/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAddressData {
    private String id;
    private String street;
    private Integer number;
    private String neighborhood;
    private String zipCode;
    private Boolean delivery;

    public static CustomerAddressData of(CustomerAddressRequest request) {
        return CustomerAddressData.builder()
                .id(request.getId())
                .street(request.getStreet())
                .number(request.getNumber())
                .neighborhood(request.getNeighborhood())
                .zipCode(request.getZipCode())
                .delivery(request.getDelivery())
                .build();
    }

    public static CustomerAddressData of(CustomerAddress address) {
        return CustomerAddressData.builder()
                .id(address.getId())
                .street(address.getStreet())
                .number(address.getNumber())
                .neighborhood(address.getNeighborhood())
                .zipCode(address.getZipCode())
                .delivery(address.getDelivery())
                .build();
    }
}
