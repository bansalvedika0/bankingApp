package controller;

import java.util.Scanner;

import model.BankAccount;
import service.BankAccountService;
import service.TransactionService;

public class WelcomeController {
	
	BankAccountService bas = new BankAccountService();
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to banking application");
		Scanner sc= new Scanner(System.in); 
		
		System.out.println("1. Login \n 2. Create bank account \n 3.Exit the application");  
        System.out.println("Enter your choice: ");  
        int option = sc.nextInt();
        System.out.println("Option selected: "+ option);
        WelcomeController obj = new WelcomeController();
        switch (option) {  
        case 1:  
            obj.login(sc);
            break;  
        case 2:  
        	obj.createAccount(sc);
            break;  
        case 3:  
            System.out.println("Application Exited");  
            break;  
    }  
	
	}
	
	public void login(Scanner sc) {
		System.out.println("Please enter username:");
		String username = sc.nextLine();
		System.out.println("Please enter password:");
		String password = sc.nextLine();
		System.out.println("Login successful.");
		BankAccount ba = bas.login(username, password);
		if(ba!=null) {
			showLoginMenu(ba);
		}else {
			System.out.println("Login failed!!! Exiting...");
		}
			
	}
	
	private void showLoginMenu(BankAccount ba) {
		Scanner sc= new Scanner(System.in); 
		System.out.println("1 to View current Balance");
		System.out.println("2 to Deposit Amount");
		System.out.println("3 to View Transactions");
		System.out.println("4 to Update Contact details");
        int option = sc.nextInt();
        System.out.println("Option selected: "+ option);
        
        BankAccountService bas = new BankAccountService();
        TransactionService ts = new TransactionService();
        switch (option) {  
        case 1:  
            bas.getBalance(ba);
            break;  
        case 2:  
            System.out.println("Enter amount to deposit: ");
            int amount = sc.nextInt();
            bas.depositAmount(ba, amount);
            break;  
        case 3:  
        	ts.viewTransaction(ba);
            break;  
        case 4:  
        	bas.updateContact(ba);
            break;  
        }
	}

	public void createAccount(Scanner sc) {
		BankAccount ba = new BankAccount();
		System.out.println("Please enter name:");
		String name = sc.nextLine();
		ba.setName(name);
		System.out.println("Please enter username:");
		String username = sc.nextLine();
		ba.setUsername(username);
		System.out.println("Please enter password:");
		String password = sc.nextLine();
		ba.setPassword(password);
		System.out.println("Please enter account number:");
		String acc = sc.nextLine();
		ba.setAccountNumber(acc);
		System.out.println("Please enter date of birth:");
		String dob = sc.nextLine();
		ba.setDob(dob);
		System.out.println("Please enter email:");
		String mailId = sc.nextLine();
		ba.setMailId(mailId);
		System.out.println("Please enter aadhar card number:");
		String aadhar = sc.nextLine();
		ba.setAadhar(aadhar);

		System.out.println("Please enter postal code:");
		String postalCode = sc.nextLine();
		ba.setPostalCode(postalCode);
		System.out.println("Please enter pan number:");
		String pan = sc.nextLine();
		ba.setPan(pan);
		System.out.println("Please enter initial balance:");
		int balance = sc.nextInt();
		ba.setBalance(balance);
		BankAccountService bas = new BankAccountService();
		boolean accountCreated = bas.createAccount(ba);
		if(accountCreated) {
			System.out.println("Account created successfully");
			showLoginMenu(ba);
		}
		else {
			System.out.println("Account creation failed!!! Exiting....");
		}
	}
}
