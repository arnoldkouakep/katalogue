package com.wemanity.domain;

import com.wemanity.domain.models.Account;

public class OCRService {
	private final OCRParser parser;
	private final AccountFormatter formatter;

	public OCRService(OCRParser parser, AccountFormatter formatter) {
		this.parser = parser;
		this.formatter = formatter;
	}

	public String processAccount(String input) {
		Account account = parser.parse(new OCRReader(input));
		return formatter.format(account);
	}
}
