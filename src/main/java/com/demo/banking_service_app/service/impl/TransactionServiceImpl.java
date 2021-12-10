package com.demo.banking_service_app.service.impl;

import com.demo.banking_service_app.entity.Transaction;
import com.demo.banking_service_app.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
}
