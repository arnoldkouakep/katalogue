package com.wemanity.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wemanity.domain.models.Account;

class OCRParserTest {
	
	private OCRParser parser;

    @BeforeEach
    void setup() {
        this.parser = new OCRParser();
    }
    
	@Test
	void testParse1() {
		String input = 
				"    _  _     _  _  _  _  _ \n" + 
				"  | _| _||_||_ |_   ||_||_|\n" + 
				"  ||_  _|  | _||_|  ||_| _|\n" + 
				"                            ";
		Account account = parser.parse(new OCRReader(input));
		assertEquals("123456789", account.getAccountNumber());
	}
	
	@Test
	void testParse2() {
		String input = 
				"    _  _     _  _  _  _  _ \n" + 
				"  | _| _||_||_ |_   ||_||_|\n" + 
				"  ||_  _|  | _||_|  | _||_|\n" + 
				"                            ";
		Account account = parser.parse(new OCRReader(input));
		assertEquals("123456798", account.getAccountNumber());
	}
	
	@Test
	void testParse3() {
		String input = 
				 " _  _  _  _  _  _  _  _       \n"+
				 "| || || || || || || ||_   |  |\n"+
				 "|_||_||_||_||_||_||_| _|  |  |\n"+
				 "                             ";
		Account account = parser.parse(new OCRReader(input));
		assertEquals("0000000511", account.getAccountNumber());
	}
}
