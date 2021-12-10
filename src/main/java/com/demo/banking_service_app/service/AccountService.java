package com.demo.banking_service_app.service;

import com.demo.banking_service_app.entity.Account;

import java.util.Collection;

public interface AccountService {

    Collection<Account> getAllAccounts();

    Account getAccountById(int id);

    Account createAccount(Account account);

    Account updateAccount(Account account);

    String deleteAccount(int id);
}
