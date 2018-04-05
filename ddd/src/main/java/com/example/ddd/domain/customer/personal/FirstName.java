package com.example.ddd.domain.customer.personal;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.util.ValidationUtil;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/17/17
 */
@EqualsAndHashCode
@Getter
public class FirstName {

    @NotEmpty
    private String value;

    private FirstName(final String value) {
        this.value = value;
        ValidationUtil.validate(this);
    }

    public static FirstName of(final String value) {
        return new FirstName(value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
