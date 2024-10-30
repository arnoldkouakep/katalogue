package com.wemanity.domain;

import com.wemanity.domain.models.Account;

public class AccountFormatter {
	public String format(Account account) {
		StringBuilder accountNumber = new StringBuilder(account.getAccountNumber());
		if (!account.hasValidNumber()) {
			return accountNumber.append(" ILL").toString();
		} else if (!account.hasValidChecksum()) {
			return accountNumber.append(" ERR").toString();
		} else
			return accountNumber.toString();
	}
}
