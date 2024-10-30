package com.wemanity.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.wemanity.domain.models.Account;

class AccountFormatterTest {

	@Test
	void testFormatValidAccount() {
		AccountFormatter formatter = new AccountFormatter();
		Account account = new Account("123456789");
		assertEquals("123456789", formatter.format(account));
	}

	@Test
	void testFormatInvalidAccount1() {
		AccountFormatter formatter = new AccountFormatter();
		Account account = new Account("1234567?9");
		assertEquals("1234567?9 ILL", formatter.format(account));
	}

	@Test
	void testFormatInvalidAccount2() {
		AccountFormatter formatter = new AccountFormatter();
		Account account = new Account("12345679");
		assertEquals("12345679 ILL", formatter.format(account));
	}

	@Test
	void testFormatInvalidAccount3() {
		AccountFormatter formatter = new AccountFormatter();
		Account account = new Account("123456799");
		assertEquals("123456799 ERR", formatter.format(account));
	}
}
