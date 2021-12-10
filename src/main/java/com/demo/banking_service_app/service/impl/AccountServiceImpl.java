package com.demo.banking_service_app.service.impl;

import com.demo.banking_service_app.entity.Account;
import com.demo.banking_service_app.entity.Transaction;
import com.demo.banking_service_app.service.AccountService;
import com.demo.banking_service_app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    private Map<Integer, Account> accounts = new HashMap<>();

    @Autowired
    private TransactionService transactionService;

    @Override
    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    @Override
    public Account getAccountById(int id) {
        return accounts.get(id);
    }

    @Override
    public Account createAccount(Account account) {
        accounts.putIfAbsent(account.getId(), account);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        if(accounts.containsKey(account.getId())) {
            accounts.put(account.getId(), account);
        }
        return account;
    }

    @Override
    public String deleteAccount(int id) {
        accounts.remove(id);
        return "Successfully deleted account with id: "+id;
    }

    @Override
    public List<Transaction> getAllTransactionsByAccountId(int id) {
        return transactionService.getAllTransactionsByAccountId(id);
    }

    @Override
    public Transaction getTransactionByTransactionId(int accountId, int transactionId) {
        return transactionService.getTransactionByTransactionId(accountId, transactionId);
    }

}
