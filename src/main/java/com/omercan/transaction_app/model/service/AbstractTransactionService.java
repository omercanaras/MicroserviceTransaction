package com.omercan.transaction_app.model.service;

import com.omercan.transaction_app.model.entity.Transaction;
import com.omercan.transaction_app.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractTransactionService implements EntityService<Transaction,Integer>
{

    @Autowired
    protected  TransactionRepository transactionRepository;




    public abstract List<Transaction> findAllByOrderByTransactionTimeDesc();

    public abstract List<Transaction> findAllByUserIdEquals(Integer userId);
}
