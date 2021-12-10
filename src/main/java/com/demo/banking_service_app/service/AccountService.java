package com.demo.banking_service_app.service;

import com.demo.banking_service_app.entity.Account;
import com.demo.banking_service_app.entity.Transaction;

import java.util.Collection;
import java.util.List;

public interface AccountService {

    Collection<Account> getAllAccounts();

    Account getAccountById(int id);

    Account createAccount(Account account);

    Account updateAccount(Account account);

    String deleteAccount(int id);

    List<Transaction> getAllTransactionsByAccountId(int id);

    Transaction getTransactionByTransactionId(int accountId, int transactionId);
}
