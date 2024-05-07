package com.omercan.transaction_app.model.service;

import com.omercan.transaction_app.model.entity.Transaction;
import com.omercan.transaction_app.model.repository.TransactionRepository;
import com.omercan.transaction_app.utility.Util;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionService extends AbstractTransactionService{



    @Override
    public List<Transaction> findAllByOrderByTransactionTimeDesc() {
        try{
            return transactionRepository.findAllByOrderByTransactionTimeDesc();
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);
        }
        return null;
     }

    @Override
    public List<Transaction> findAllByUserIdEquals(Integer userId) {
    try{

    return transactionRepository.findAllByUserIdEquals(userId);
        }
    catch (Exception e)
    {
    Util.showGeneralExceptionInfo(e);
    }

        return null;
    }

    @Override
    public void deletedById(Integer ID) {
        try{
            transactionRepository.deleteById(ID);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);

        }
    }

    @Override
    public Transaction findById(Integer ID) {
        try {
            return transactionRepository.findById(ID).orElseThrow(() -> new RuntimeException("Entity is not found"));

        } catch (Exception e) {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public Transaction save(Transaction entity) {
        try {
            return transactionRepository.save(entity);
        }
        catch(IllegalArgumentException e)
        {

            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
