package com.example.domain;

import java.io.Serializable;

import org.axonframework.common.IdentifierFactory;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by mmatsumoto on 4/18/17
 */
@Getter
@EqualsAndHashCode
@ToString
public class AccountId implements Serializable {

    private static final long serialVersionUID = -7126835531886253812L;

    private String accountId;

    public AccountId() {
        this.accountId = IdentifierFactory.getInstance().generateIdentifier();
    }

    public AccountId(String accountId) {
        this.accountId = accountId;
    }
}
