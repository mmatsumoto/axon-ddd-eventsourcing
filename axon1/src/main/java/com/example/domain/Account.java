package com.example.domain;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.coreapi.AccountCreatedEvent;
import com.example.coreapi.CreateAccountCommand;
import com.example.coreapi.MoneyWithdrawnEvent;
import com.example.coreapi.WithdrawMoneyCommand;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by mmatsumoto on 4/18/17
 */
@Aggregate
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Account {

    @AggregateIdentifier
    private AccountId id;
    private Integer overdraftLimit;
    private Integer balance;

    @CommandHandler
    public Account(CreateAccountCommand command) {
        apply( new AccountCreatedEvent(command.getAccountId(), command.getOverdraftLimit(), command.getDeposit()));
    }

    @CommandHandler
    public AccountId withdrawMoney(WithdrawMoneyCommand command) {
        if( command.getAmount() > overdraftLimit) {
            throw new OverdraftLimitExceededException();
        }
        if(balance < command.getAmount() ) {
            throw new BalanceExceededException();
        }
        apply(new MoneyWithdrawnEvent(command.getAccountId(), command.getAmount()));
        return command.getAccountId();
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        this.id = event.getAccountId();
        this.overdraftLimit = event.getOverdraftLimit();
        this.balance = event.getBalance();
    }

    @EventSourcingHandler
    public void on(MoneyWithdrawnEvent event) {
        this.balance -= event.getAmount();
    }

}
