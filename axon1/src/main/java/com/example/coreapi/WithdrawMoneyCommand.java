package com.example.coreapi;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.example.domain.AccountId;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by mmatsumoto on 4/18/17
 */
@Getter
@AllArgsConstructor
public class WithdrawMoneyCommand {

    @TargetAggregateIdentifier
    private AccountId accountId;

    private Integer amount;
}
