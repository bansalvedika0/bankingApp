package com.vedika.transactionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.transactionservice.entity.Transaction;
import com.vedika.transactionservice.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService service;

	@PostMapping("/debittransaction")
	public Transaction debitTransaction(@RequestBody Transaction transaction) {
		return service.debitTransaction(transaction);
	}
	
	@PostMapping("/credittransaction")
	public Transaction creditTransaction(@RequestBody Transaction transaction) {
		return service.creditTransaction(transaction);
	}
	
	@GetMapping("/history")
	public List<Transaction> getHistory(@RequestParam int accountNumber){
		return service.getHistory(accountNumber);
	}
}
