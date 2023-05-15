package com.vedika.bankservice.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.vedika.bankservice.entity.BankAccount;

@Repository
public class BankAccountRepository {
	
	static ArrayList<BankAccount> list= new ArrayList<>();

	public BankAccount createAccount(BankAccount ba) {
		list.add(ba);
		return ba;
	}

	public BankAccount updateAccount(BankAccount ba) {
		// TODO Auto-generated method stub
		return ba;
	}

	public double getBalance(int accountNumber) {
		
		return list.stream().filter(ba -> ba.getAccountNumber()==accountNumber).findFirst().get().getBalance();
	}

}