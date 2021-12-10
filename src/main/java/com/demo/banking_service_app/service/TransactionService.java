package com.demo.banking_service_app.service;

import com.demo.banking_service_app.entity.Transaction;

import java.util.Collection;
import java.util.List;

public interface TransactionService {

    Collection<Transaction> getAllTransactions();

    Transaction getTransactionById(int id);

    Transaction createTransaction(Transaction transaction);

    Transaction updateTransaction(Transaction transaction);

    String deleteTransaction(int id);

    List<Transaction> getAllTransactionsByAccountId(int id);

    Transaction getTransactionByTransactionId(int accountId, int transactionId);
}
