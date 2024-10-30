package com.wemanity.domain.models;

public class Account {
	private final String accountNumber;

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public boolean hasValidNumber() {
		return accountNumber.length() == 9 && !accountNumber.contains("?");
	}

	public boolean hasValidChecksum() {
		int sum = 0;
		for (int i = 0; i < accountNumber.length(); i++) {
			int digit = Character.getNumericValue(accountNumber.charAt(i));
			sum += digit * (9 - i);
		}
		return sum % 11 == 0;
	}
}
