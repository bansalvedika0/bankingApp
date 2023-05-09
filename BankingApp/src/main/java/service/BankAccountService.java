package service;

import model.BankAccount;
import repository.BankAccountRepo;
import repository.TransactionRepo;

public class BankAccountService {
	BankAccountRepo repo = new BankAccountRepo();
	TransactionRepo tRepo = new TransactionRepo();
	
	public void getBalance(BankAccount ba) {
		int balance = repo.getBalance(ba.getUsername());
		System.out.println("Balance is : "+balance);
	}

	public boolean depositAmount(BankAccount ba, int amount) {
        // validations
        if (amount <=0) {
            System.out.println("Invalid amount");
            return false;
        }
        repo.depositAmount(ba, amount+ba.getBalance());
        tRepo.depositAmount(ba, amount);
        return true;
        
	}

	public void updateContact(BankAccount ba) {
		
	}

	public Boolean createAccount(BankAccount ba) {
        // validations
        if (ba.getName() == "" ) {
            System.out.println("All Field Required!");
            return false;
        }
        
        return repo.createAccount(ba);
	}

	public BankAccount login(String username, String password) {
		//validations
		if (username == "" || password == "") {
            System.out.println("All fields are required!");
            return null;
        }
		
        return repo.login(username, password);

	}

}
