package com.demo.banking_service_app.service.impl;

import com.demo.banking_service_app.entity.Transaction;
import com.demo.banking_service_app.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private Map<Integer, Transaction> transactions = new HashMap<>();

    @Override
    public Collection<Transaction> getAllTransactions() {
        return transactions.values();
    }

    @Override
    public Transaction getTransactionById(int id) {
        return transactions.get(id);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        transactions.putIfAbsent(transaction.getId(), transaction);
        return transaction;
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        if(transactions.containsKey(transaction.getId())) {
            transactions.put(transaction.getId(), transaction);
        }
        return transaction;
    }

    @Override
    public String deleteTransaction(int id) {
        transactions.remove(id);
        return "Successfully deleted transaction with id: "+id;
    }

    @Override
    public List<Transaction> getAllTransactionsByAccountId(int id) {
        return transactions.values().stream().filter(transaction -> transaction.getAccount().getId() == id).collect(Collectors.toList());
    }

    @Override
    public Transaction getTransactionByTransactionId(int accountId, int transactionId) {
        Optional<Transaction> transactionOptional = transactions.values().stream()
                .filter(transaction -> transaction.getId() == transactionId && transaction.getAccount().getId() == accountId)
                .findAny();
        return transactionOptional.orElse(new Transaction());
    }
}
