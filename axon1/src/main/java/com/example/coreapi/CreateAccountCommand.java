package com.example.coreapi;

import com.example.domain.AccountId;

import lombok.Getter;

/**
 * Created by mmatsumoto on 4/18/17.
 */
@Getter
public class CreateAccountCommand {

    private AccountId accountId;

    private Integer overdraftLimit;

    private Integer deposit;

    public CreateAccountCommand() {
        this.accountId = new AccountId();
    }

    public static CreateAccountCommand of(Integer overdraftLimit, Integer deposit) {
        CreateAccountCommand command = new CreateAccountCommand();
        command.overdraftLimit = overdraftLimit;
        command.deposit = deposit;
        return command;
    }
}
