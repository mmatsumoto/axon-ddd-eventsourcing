package com.example;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.coreapi.CreateAccountCommand;
import com.example.coreapi.WithdrawMoneyCommand;
import com.example.domain.AccountId;
import com.example.query.AccountBalance;
import com.example.query.AccountBalanceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by mmatsumoto on 4/18/17
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountBalanceRepository repository;
    private final CommandGateway commandGateway;

    @Autowired
    public AccountController(AccountBalanceRepository repository,
            @SuppressWarnings("SpringJavaAutowiringInspection")
                    CommandGateway commandGateway) {
        this.repository = repository;
        this.commandGateway = commandGateway;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public AccountId create(@RequestBody CreateAccountCommand command) {
        return commandGateway.sendAndWait(command);
    }

    @PutMapping(path="{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public AccountId withdrawMoney(
            @PathVariable AccountId id,
            @RequestBody ModelMap request) {

        request.put("accountId", id);
        WithdrawMoneyCommand command =
                new ObjectMapper().convertValue(request, WithdrawMoneyCommand.class);

        return commandGateway.sendAndWait(command);
    }

    @GetMapping
    public List<AccountBalance> findAll() {
        return repository.findAll();
    }
}
