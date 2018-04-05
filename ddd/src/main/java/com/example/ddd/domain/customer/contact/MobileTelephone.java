package com.example.ddd.domain.customer.contact;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.util.ValidationUtil;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/17/17
 */
@EqualsAndHashCode
@Getter
public class MobileTelephone {

    @NotNull
    @Size(min = 1, max = 99)
    private final CountryCode countryCode;

    @NotNull
    @Size(min = 10, max = 99)
    private final AreaCode areaCode;

    @NotNull
    private final TelephoneNumber number;

    private MobileTelephone(final CountryCode countryCode, final AreaCode areaCode, final TelephoneNumber number) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
        ValidationUtil.validate(this);
    }

    public static MobileTelephone of(final CountryCode countryCode, final AreaCode areaCode, final TelephoneNumber number) {
        return new MobileTelephone(countryCode, areaCode, number);
    }

}
