package com.vedika.transactionservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.vedika.transactionservice.entity.Transaction;

@Repository
public class TransactionRepository {
	
	static ArrayList<Transaction> list;
	
	public Transaction debitTransaction(Transaction transaction) {
		list.add(transaction);
		return transaction;
	}
	
	public Transaction creditTransaction(Transaction transaction) {
		list.add(transaction);
		return transaction;
	}

	public List<Transaction> getHistory(int accountNumber) {
		return list.stream().filter(element -> element.getAccountNumber()==accountNumber).collect(Collectors.toList());
	}
}
