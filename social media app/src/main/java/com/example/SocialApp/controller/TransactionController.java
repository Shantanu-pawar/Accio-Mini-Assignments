package com.example.SocialApp.controller;


import com.example.SocialApp.DTOs.AddTransactionDto;
import com.example.SocialApp.DTOs.FindSuccessfulTransaction;
import com.example.SocialApp.models.Transaction;
import com.example.SocialApp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @PostMapping("/add")
    public ResponseEntity<?> addTransaction(@RequestBody AddTransactionDto user){
        try {
            String res = transactionService.addTransaction(user);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getSuccessfulTransactions")
    public ResponseEntity<?> findSuccessTransactions(@RequestBody FindSuccessfulTransaction user){
        try {
            List<Transaction> list = transactionService.findTotalSuccessfulTransaction(user);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteFailedTransaction")
    public ResponseEntity<?> deleteFailedTransactions(@RequestBody FindSuccessfulTransaction user){
        try {
            String res = transactionService.deleteFailedTransaction(user);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
