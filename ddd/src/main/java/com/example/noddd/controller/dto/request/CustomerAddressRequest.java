package com.example.noddd.controller.dto.request;

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
public class CustomerAddressRequest {
    private String id;
    private String street;
    private Integer number;
    private String neighborhood;
    private String zipCode;
    private Boolean delivery;
}
