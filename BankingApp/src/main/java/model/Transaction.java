package model;

public class Transaction {
	String accountNumber;
	String transaction;
	
	@Override
	public String toString() {
		return "Transaction [accountNumber=" + accountNumber + ", transaction=" + transaction + "]";
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

}
