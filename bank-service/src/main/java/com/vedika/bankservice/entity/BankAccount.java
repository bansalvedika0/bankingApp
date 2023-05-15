package com.vedika.bankservice.entity;

import lombok.Data;

@Data
public class BankAccount {
	private String name;
	private String username;
	private String password;
	private String mailId;
	private String phone;
	private String dob;
	private String pan;
	private String aadhar;
	private Integer accountNumber;
	private Double balance;
}
