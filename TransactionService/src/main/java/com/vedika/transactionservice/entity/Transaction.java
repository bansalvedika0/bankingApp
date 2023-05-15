package com.vedika.transactionservice.entity;

import lombok.Data;

@Data
public class Transaction {

	Integer accountNumber;
	String message;
	String type;
	Integer amount;
}
