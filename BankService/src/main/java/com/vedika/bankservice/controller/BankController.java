package com.vedika.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.bankservice.entity.BankAccount;
import com.vedika.bankservice.service.BankAccountService;

@RestController
public class BankController {
	
	@Autowired
	BankAccountService bankAccountService;
	
	@PostMapping(value = "/account")
	public int createAccount(@RequestBody BankAccount ba) {
		return bankAccountService.createAccount(ba).getAccountNumber();
	}
	
	@PutMapping(value = "/account")
	public int updateAccount(@RequestBody BankAccount ba) {
		return bankAccountService.updateAccount(ba).getAccountNumber();
	}
	
	@GetMapping(value = "/balance")
	public double checkBalance(@RequestParam int accountNumber) {
		return bankAccountService.getBalance(accountNumber);
	}
	

}