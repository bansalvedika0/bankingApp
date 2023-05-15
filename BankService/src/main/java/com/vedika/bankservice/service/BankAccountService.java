package com.vedika.bankservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedika.bankservice.entity.BankAccount;
import com.vedika.bankservice.repository.BankAccountRepository;

@Service
public class BankAccountService {
	
	@Autowired
	BankAccountRepository repo;
	
	public BankAccount createAccount(BankAccount ba) {
		
		return repo.createAccount(ba);
	}

	public BankAccount updateAccount(BankAccount ba) {
		
		return repo.updateAccount(ba);
	}

	public double getBalance(int accountNumber) {
		
		return repo.getBalance(accountNumber);
	}

}