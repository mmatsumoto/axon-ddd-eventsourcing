package com.example.noddd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity
public class CustomerAddress {
    @Id
    private String id;

    @Column
    private String street;

    @Column
    private Integer number;

    @Column
    private String neighborhood;

    @Column
    private String zipCode;

    @Column
    private Boolean delivery;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
