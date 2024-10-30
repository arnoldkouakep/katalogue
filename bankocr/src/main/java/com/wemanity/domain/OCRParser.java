package com.wemanity.domain;

import java.util.HashMap;
import java.util.Map;

import com.wemanity.domain.models.Account;

public class OCRParser {
	private final Map<String, Integer> digitMap;

	public OCRParser() {
		this.digitMap = initializeDigitMap();
	}
	private Map<String, Integer> initializeDigitMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put(" _ | ||_|", 0);
        map.put("     |  |", 1);
        map.put(" _  _||_ ", 2);
        map.put(" _  _| _|", 3);
        map.put("   |_|  |", 4);
        map.put(" _ |_  _|", 5);
        map.put(" _ |_ |_|", 6);
        map.put(" _   |  |", 7);
        map.put(" _ |_||_|", 8);
        map.put(" _ |_| _|", 9);
        return map;
    }
	public int parseDigit(String[] digitLines) {
		String digitString = String.join("", digitLines);
		return digitMap.getOrDefault(digitString, -1);
	}

	public Account parse(OCRReader reader) {
		StringBuilder accountNumber = new StringBuilder();

		for (int i = 0; i < reader.getTotalDigits(); i++) {
			int digit = parseDigit(reader.getCharacter(i));
			accountNumber.append(digit == -1 ? "?" : digit);
		}

		return new Account(accountNumber.toString());
	}
}
