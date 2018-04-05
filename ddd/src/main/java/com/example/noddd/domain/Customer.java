package com.example.noddd.domain;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = -1082606755535322983L;

    @Id
    private String id;

    @Column
    private String firstName;

    @Column
    private String middleName;

    @Column
    private String lastName;

    @Column
    private Gender gender;

    @Column
    private LocalDateTime birthday;

    @OneToMany(mappedBy = "customer", cascade = ALL, orphanRemoval = true)
    private Set<CustomerContact> contacts;

    @OneToMany(mappedBy = "customer", cascade = ALL, orphanRemoval = true)
    private Set<CustomerAddress> addresses;

}
