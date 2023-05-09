package service;

import java.util.ArrayList;

import model.BankAccount;
import model.Transaction;
import repository.TransactionRepo;

public class TransactionService {

	TransactionRepo repo = new TransactionRepo();
	public void viewTransaction(BankAccount ba) {
		ArrayList<Transaction> list = repo.getTransaction(ba);
		System.out.println(list);
	}

}
