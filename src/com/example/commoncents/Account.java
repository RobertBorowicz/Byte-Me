package com.example.commoncents;

public class Account {

	private String accountName;
	private String displayName;
	private String accountOwner;
	private double startingBalance;
	private double interest;

	public Account(String accountName, String displayName, String accountOwner, double startingBalance, double interest) {
		this.accountName = accountName;
		this.displayName = displayName;
		this.accountOwner = accountOwner;
		this.startingBalance = startingBalance;
		this.interest = interest;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public String getAccountOwner() {
		return this.accountOwner;
	}
	
	public double getBalance() {
		return this.startingBalance;
	}
	
	public double getInterest() {
		return this.interest;
	}

}
