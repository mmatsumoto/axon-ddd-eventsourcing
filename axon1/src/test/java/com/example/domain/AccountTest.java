package com.example.domain;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

import com.example.coreapi.AccountCreatedEvent;
import com.example.coreapi.CreateAccountCommand;
import com.example.coreapi.MoneyWithdrawnEvent;
import com.example.coreapi.WithdrawMoneyCommand;

/**
 * Created by mmatsumoto on 4/18/17
 */

public class AccountTest {

    private FixtureConfiguration<Account> fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new AggregateTestFixture<>(Account.class);
    }

    @Test
    public void createAccount() {
        AccountId accountId = new AccountId();
        fixture.givenNoPriorActivity()
                .when(CreateAccountCommand.of( 500, 1000))
                .expectEvents(new AccountCreatedEvent(accountId, 500, 1000));
    }

    @Test
    public void withdrawMoney() {
        AccountId accountId = new AccountId();
        fixture.given(
                new AccountCreatedEvent(accountId, 500, 1000))
                .when(new WithdrawMoneyCommand(accountId, 500))
                .expectEvents(new MoneyWithdrawnEvent(accountId, 500));
    }

    @Test
    public void withdrawMoneyTwice() {
        AccountId accountId = new AccountId();
        fixture.given(
                new AccountCreatedEvent(accountId, 800, 1000),
                new MoneyWithdrawnEvent(accountId, 700))
                .when(new WithdrawMoneyCommand(accountId, 400))
                .expectNoEvents()
                .expectException(BalanceExceededException.class);
    }

    @Test
    public void withdrawMoneyAbsurdAmount() {
        AccountId accountId = new AccountId();
        fixture.given(
                new AccountCreatedEvent(accountId, 500, 1000))
                .when(new WithdrawMoneyCommand(accountId, 501))
                .expectNoEvents()
                .expectException(OverdraftLimitExceededException.class);
    }

    @Test
    public void withdrawMoneyInvalidBalance() {
        AccountId accountId = new AccountId();
        fixture.given(
                new AccountCreatedEvent(accountId, 5000, 1000))
                .when(new WithdrawMoneyCommand(accountId, 1001))
                .expectNoEvents()
                .expectException(BalanceExceededException.class);
    }

}