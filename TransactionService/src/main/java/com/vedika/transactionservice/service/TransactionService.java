package com.vedika.transactionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedika.transactionservice.entity.Transaction;
import com.vedika.transactionservice.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repository;
	
	public Transaction debitTransaction(Transaction transaction) {

		return repository.debitTransaction(transaction);
	}

	public Transaction creditTransaction(Transaction transaction) {

		return repository.creditTransaction(transaction);
	}

	public List<Transaction> getHistory(int accountNumber) {
		
		return repository.getHistory(accountNumber);
	}
}
