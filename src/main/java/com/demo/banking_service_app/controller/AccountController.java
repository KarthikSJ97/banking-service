package com.demo.banking_service_app.controller;

import com.demo.banking_service_app.entity.Account;
import com.demo.banking_service_app.entity.Transaction;
import com.demo.banking_service_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public Collection<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable("id") int id, @RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable("id") int id) {
        return accountService.deleteAccount(id);
    }

    @GetMapping("/{id}/transactions")
    public List<Transaction> getAllTransactionsByAccountId(@PathVariable("id") int id) {
        return accountService.getAllTransactionsByAccountId(id);
    }

    @GetMapping("/{id}/transactions/{transactionId}")
    public Transaction getTransactionByTransactionId(@PathVariable("id") int accountId,
                                                     @PathVariable("transactionId") int transactionId) {
        return accountService.getTransactionByTransactionId(accountId, transactionId);
    }

}
