package com.wemanity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.wemanity.domain.AccountFormatter;
import com.wemanity.domain.OCRParser;
import com.wemanity.domain.OCRService;

class BankOCRTest {

	@Test
	void testValidNumbers() {
		OCRParser parser = new OCRParser();
		AccountFormatter formatter = new AccountFormatter();
		OCRService service = new OCRService(parser, formatter);

		String input1 = " _  _  _  _  _  _  _  _  _ \n" + 
						"| || || || || || || || || |\n" + 
						"|_||_||_||_||_||_||_||_||_|\n" + 
						"                           ";
		String result1 = service.processAccount(input1);
		assertEquals("000000000", result1);


		String input2 = "    _  _     _  _  _  _  _ \n" + 
						"  | _| _||_||_ |_   ||_||_|\n" + 
						"  ||_  _|  | _||_|  ||_| _|\n" + 
						"                           ";
		String result2 = service.processAccount(input2);
		assertEquals("123456789", result2);
	}

	@Test
	void testSingleIllisibleCharacter() {
		String input = "    _  _  _  _  _  _     _ \n" + 
					   "|_||_|| || ||_   |  |  | _ \n" + 
					   "  | _||_||_||_|  |  |  | _|\n" + 
					   "                           ";

		OCRParser parser = new OCRParser();
		AccountFormatter formatter = new AccountFormatter();
		OCRService service = new OCRService(parser, formatter);
		String result = service.processAccount(input);
		assertEquals("49006771? ILL", result);
	}

	@Test
	void testMultipleIllisibleCharacters() {
		String input = "    _  _     _  _  _  _  _ \n" +
					   " _| _| _||_| _ |_   ||_||_|\n" + 
					   "  ||_  _|  | _||_|  ||_| _ \n" + 
					   "                           ";

		OCRParser parser = new OCRParser();
		AccountFormatter formatter = new AccountFormatter();
		OCRService service = new OCRService(parser, formatter);
		String result = service.processAccount(input);
		assertEquals("?234?678? ILL", result);
	}

	@Test
	void testErrorCorrection() {
		String input = " _  _  _  _  _  _  _  _    \n" + 
					   "| || || || || || || ||_   |\n" + 
					   "|_||_||_||_||_||_||_| _|  |\n" + 
					   "                           ";
		OCRParser parser = new OCRParser();
		AccountFormatter formatter = new AccountFormatter();
		OCRService service = new OCRService(parser, formatter);
		String result = service.processAccount(input);
		assertEquals("000000051", result);
	}

}
