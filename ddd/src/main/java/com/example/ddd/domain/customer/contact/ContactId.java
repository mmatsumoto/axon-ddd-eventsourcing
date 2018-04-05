package com.example.ddd.domain.customer.contact;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.util.ValidationUtil;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/17/17
 */
@Getter
@EqualsAndHashCode
public class ContactId {

    @NotNull
    @Size(min = 32, max = 32)
    private final String value;

    private ContactId(final String value) {
        this.value = value;
        ValidationUtil.validate(this);
    }

    public static ContactId of(final String value) {
        return new ContactId(value);
    }

    public static ContactId newInstance() {
        return new ContactId(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return this.value;
    }
}
