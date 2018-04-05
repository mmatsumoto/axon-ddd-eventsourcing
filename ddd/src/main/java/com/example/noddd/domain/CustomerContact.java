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
 * Created by mmatsumoto on 4/16/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CustomerContact {
    @Id
    private String id;

    @Column
    private String email;

    @Column
    private String mobileTelephone;

    @Column
    private String homeTelephone;

    @Column
    private Boolean main;

    public boolean isMain() {
        return Boolean.TRUE.equals(main);
    }

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
