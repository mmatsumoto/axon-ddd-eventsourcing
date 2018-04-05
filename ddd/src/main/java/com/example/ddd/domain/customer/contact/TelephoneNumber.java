package com.example.ddd.domain.customer.contact;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.util.ValidationUtil;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/17/17
 */
@EqualsAndHashCode
@Getter
public class TelephoneNumber {

    @NotEmpty
    @Pattern(regexp = "\\d{4}")
    private final String prefix;

    @NotEmpty
    @Pattern(regexp = "\\d{4}")
    private final String number;

    private TelephoneNumber(final String prefix, final String number) {
        this.prefix = prefix;
        this.number = number;
        ValidationUtil.validate(this);
    }

    public static TelephoneNumber of(final String prefix, final String number) {
        return new TelephoneNumber(prefix, number);
    }

    @Override
    public String toString() {
        return this.prefix + "-" + this.number;
    }
}
