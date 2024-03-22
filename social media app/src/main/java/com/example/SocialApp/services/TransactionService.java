package com.example.SocialApp.services;

import com.example.SocialApp.DTOs.AddTransactionDto;
import com.example.SocialApp.DTOs.FindSuccessfulTransaction;
import com.example.SocialApp.models.Transaction;
import com.example.SocialApp.models.User;
import com.example.SocialApp.repository.TransactionRepo;
import com.example.SocialApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private UserRepository userRepository;

    public String addTransaction(AddTransactionDto addTransactionDto) throws Exception{
        // validation check user is available in db or not
        Optional<User> op = userRepository.findById(addTransactionDto.getUserId());

        if(!op.isPresent()){
            throw new Exception("user is not present please register it then continue");
        }

        Transaction transaction = new Transaction();
        transaction.setAmount(addTransactionDto.getAmount());
        transaction.setStatus(addTransactionDto.getStatus());
        transaction.setAmountDeducted(addTransactionDto.getAmountDeducted());

        User user = op.get();
        transaction.setUser(user);
        transaction = transactionRepo.save(transaction);

        // how to set into list
        user.getTransactionList().add(transaction);
        return "Transaction was completed successfully";
    }

    public List<Transaction> findTotalSuccessfulTransaction(FindSuccessfulTransaction ts){

        int id = ts.getUserId();
        Optional<User> userOptional = userRepository.findById(id);

        List<Transaction> transactionList = userOptional.get().getTransactionList();

        for(Transaction transaction : transactionList){
            if(transaction.getStatus().equals(ts.getStatus())){

            }
        }

        String status = ts.getStatus();
        List<Transaction> list = transactionRepo.findByStatus(status);

        return list;
    }

    public String deleteFailedTransaction(FindSuccessfulTransaction ts){

        String status = ts.getStatus();
        List<Transaction> list = transactionRepo.findByStatus(status);

        for(Transaction transaction : list){
            transactionRepo.delete(transaction);
        }

        return "all failed Transactions deleted successfully";
    }
}
