package com.demo.banking_service_app.service.impl;

import com.demo.banking_service_app.entity.Account;
import com.demo.banking_service_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    private Map<Integer, Account> accounts = new HashMap<>();

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

}
