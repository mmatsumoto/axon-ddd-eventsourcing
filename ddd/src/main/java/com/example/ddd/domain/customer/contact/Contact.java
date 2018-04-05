package com.example.ddd.domain.customer.contact;

import static lombok.AccessLevel.PROTECTED;

import com.example.ddd.domain.customer.CustomerId;
import com.example.ddd.domain.customer.personal.Email;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by mmatsumoto on 4/16/17
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class Contact {

    private ContactId id;

    private CustomerId customerId;

    private Email email;

    private HomeTelephone homeTelephone;

    private MobileTelephone mobileTelephone;

    private boolean main;

    public Contact(ContactId id, CustomerId customerId, Email email, boolean main) {
        this.id = id;
        this.customerId = customerId;
        this.email = email;
        this.main = main;
    }

    public Contact changeEmail(Email changedEmail) {
        this.email = changedEmail;
        return this;
    }
}
