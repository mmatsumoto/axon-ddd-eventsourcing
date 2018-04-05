package com.example.ddd.domain.customer;

import java.io.Serializable;
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
public class CustomerId implements Serializable {

    private static final long serialVersionUID = -505430410003938248L;
    @NotNull
    @Size(min = 32, max = 32)
    private final String value;

    private CustomerId(final String value) {
        this.value = value;
        ValidationUtil.validate(this);
    }

    public static CustomerId of(final String value) {
        return new CustomerId(value);
    }

    public static CustomerId newInstance() {
        return new CustomerId(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return this.value;
    }
}
