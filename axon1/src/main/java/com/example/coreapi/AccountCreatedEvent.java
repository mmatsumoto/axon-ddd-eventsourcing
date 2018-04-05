package com.example.coreapi;

import com.example.domain.AccountId;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/18/17
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class AccountCreatedEvent {

    private AccountId accountId;

    private Integer overdraftLimit;

    private Integer balance;
}
