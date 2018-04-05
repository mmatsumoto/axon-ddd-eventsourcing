package com.example.query;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.domain.AccountId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by mmatsumoto on 4/18/17
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "accountId", callSuper = false)
public class AccountBalance {

    @Id
    @EmbeddedId
    private AccountId accountId;

    @Column
    private Integer balance;

    public void withdrawMoney(Integer amount) {
        this.balance -= amount;
    }
}
