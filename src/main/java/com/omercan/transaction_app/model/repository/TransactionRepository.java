package com.omercan.transaction_app.model.repository;

import com.omercan.transaction_app.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findAllByOrderByTransactionTimeDesc();

    List<Transaction> findAllByUserIdEquals(Integer userId);
}
