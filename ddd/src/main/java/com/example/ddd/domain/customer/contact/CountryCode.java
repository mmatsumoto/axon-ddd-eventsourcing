package com.example.ddd.domain.customer.contact;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.util.ValidationUtil;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/17/17
 */
@EqualsAndHashCode
@Getter
public class CountryCode {

    @NotEmpty
    @Size(max = 2, min = 2)
    private final Integer value;

    private CountryCode(final Integer value) {
        this.value = value;
        ValidationUtil.validate(this);
    }

    public static CountryCode of(final Integer value) {
        return new CountryCode(value);
    }

    @Override
    public String toString() {
        return value != null ? value.toString() : super.toString();
    }
}
