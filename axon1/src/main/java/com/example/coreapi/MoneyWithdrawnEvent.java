package com.example.coreapi;

import com.example.domain.AccountId;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/18/17
 */
@AllArgsConstructor
@Getter
public class MoneyWithdrawnEvent {

    private AccountId accountId;

    private Integer amount;
}
