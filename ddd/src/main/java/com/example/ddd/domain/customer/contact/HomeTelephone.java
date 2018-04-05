package com.example.ddd.domain.customer.contact;

import javax.validation.constraints.NotNull;

import com.example.util.ValidationUtil;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/17/17
 */
@EqualsAndHashCode
@Getter
public class HomeTelephone {

    @NotNull
    private final CountryCode countryCode;

    @NotNull
    private final AreaCode areaCode;

    @NotNull
    private final TelephoneNumber number;

    private HomeTelephone(final CountryCode countryCode, final AreaCode areaCode, final TelephoneNumber number) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
        ValidationUtil.validate(this);
    }

    public static HomeTelephone of(final CountryCode countryCode, final AreaCode areaCode, final TelephoneNumber number) {
        return new HomeTelephone(countryCode, areaCode, number);
    }

}
