package com.omercan.transaction_app.controller;

import com.omercan.transaction_app.model.entity.Transaction;
import com.omercan.transaction_app.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/transaction")
@RestController()
public class TransactionController {

    @Autowired
    private  AbstractTransactionService transactionService;




    @GetMapping()
    public ResponseEntity<List<Transaction>> getAllSortByTransactionTime()
    {
        List<Transaction> transactionList = transactionService.findAllByOrderByTransactionTimeDesc();


        return ResponseEntity.ok(transactionList);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Transaction>> getUsersTransactions(@PathVariable Integer id){

        List<Transaction> transactionList= transactionService.findAllByUserIdEquals(id);

        return ResponseEntity.ok(transactionList);

    }

    @GetMapping("{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Integer id)
    {
        Transaction foundTransaction = transactionService.findById(id);

        return foundTransaction!=null ? new ResponseEntity<>(foundTransaction, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @PostMapping()
    public ResponseEntity<Transaction>  save(@RequestBody Transaction transaction)
    {

            transaction.setTransactionTime(new Date());
            transactionService.save(transaction);

            return new ResponseEntity<>(transaction,HttpStatus.CREATED);



    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {

        Transaction productFound = transactionService.findById(id);

        if (productFound != null) {
            transactionService.deletedById(id);
            return ResponseEntity.ok("Transaction that have productId: " + id + "has been deleted");


        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
