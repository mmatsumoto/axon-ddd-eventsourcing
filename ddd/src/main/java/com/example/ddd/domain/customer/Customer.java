package com.example.ddd.domain.customer;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.example.ddd.domain.customer.address.Address;
import com.example.ddd.domain.customer.contact.Contact;
import com.example.ddd.domain.customer.contact.HomeTelephone;
import com.example.ddd.domain.customer.personal.Email;
import com.example.ddd.domain.customer.personal.FirstName;
import com.example.ddd.domain.customer.personal.LastName;
import com.example.ddd.domain.customer.personal.MiddleName;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by mmatsumoto on 4/17/17
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Customer {

    @NotNull
    @Id
    private CustomerId customerId;

    @NotNull
    private FirstName firstName;

    private MiddleName middleName;

    @NotNull
    private LastName lastName;

    private Set<Contact> contacts;

    private Set<Address> addresses;

    public static Customer createCustomer(
            final FirstName firstName,
            final MiddleName middleName,
            final LastName lastName,
            final Contact contact,
            final CustomerRepository repository) {

        Customer customer = new Customer(
                CustomerId.newInstance(),
                firstName,
                middleName,
                lastName,
                Collections.singleton(contact),
                new LinkedHashSet<>());

        return repository.save(customer);
    }

    public Customer changePersonalEmail(final Email changedEmail, final CustomerRepository repository) {

        getMainContact()
                .ifPresent( mainContact -> mainContact.changeEmail(changedEmail) );

        return repository.save(this);
    }

    private Optional<Contact> getMainContact() {
        return this.getContacts().stream().filter(Contact::isMain).findFirst();
    }

    public Customer changeHomeTelephone(final HomeTelephone changedHomeTelephone, final CustomerRepository repository) {
        // TODO
        return null;
    }

    public Customer realocateTo(final Address changedAddress, final CustomerRepository repository) {

        // TODO
        return null;
    }
}
