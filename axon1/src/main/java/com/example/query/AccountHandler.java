package com.example.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.example.coreapi.AccountCreatedEvent;
import com.example.coreapi.MoneyWithdrawnEvent;

/**
 * Created by mmatsumoto on 4/18/17
 */
@ProcessingGroup("accountBalance")
@Component
public class AccountHandler {

    private final AccountBalanceRepository repository;

    public AccountHandler(AccountBalanceRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(AccountCreatedEvent event) {
        AccountBalance accountBalance =
                new AccountBalance(event.getAccountId(), event.getBalance());
        repository.save(accountBalance);
    }

    @EventHandler
    public void on(MoneyWithdrawnEvent event) {
        AccountBalance accountBalance = repository.findOne(event.getAccountId());
        accountBalance.withdrawMoney(event.getAmount());
        repository.save(accountBalance);
    }
}
