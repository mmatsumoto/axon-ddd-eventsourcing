package com.example.noddd.controller.dto.request;

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
public class CustomerContactRequest {
    private String id;
    private String email;
    private String mobileTelephone;
    private String homeTelephone;
    private Boolean main;
}
