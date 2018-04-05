package com.example.query;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.AccountId;

/**
 * Created by mmatsumoto on 4/18/17
 */
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, AccountId> {
}
