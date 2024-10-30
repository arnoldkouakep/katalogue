package com.wemanity.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OCRServiceTest {

    private OCRService service;

    @BeforeEach
    void setup() {
        OCRParser parser = new OCRParser();
        AccountFormatter formatter = new AccountFormatter();
        service = new OCRService(parser, formatter);
    }
    
    @Test
    void testProcessValidAccount() {
        String input = " _  _  _  _  _  _  _  _  _ \n" +
                       "| || || || || || || || || |\n" +
                       "|_||_||_||_||_||_||_||_||_|\n" +
                       "                           ";
        assertEquals("000000000", service.processAccount(input));
    }
    
	@Test
	void testProcessAccount() {
		String input = " _  _  _  _  _  _  _  _    \n" + 
					   "| || || || || || || ||_   |\n" + 
					   "|_||_||_||_||_||_||_| _|  |\n" + 
					   "                           ";
		assertEquals("000000051", service.processAccount(input));
	}
	
    @Test
    void testProcessIllisibleCharacter() {
        String input = "    _  _  _  _  _  _     _ \n" +
                       "|_||_|| || ||_   |  |  | _ \n" +
                       "  | _||_||_||_|  |  |  | _|\n" +
                       "                           ";
        assertEquals("49006771? ILL", service.processAccount(input));
    }
}
