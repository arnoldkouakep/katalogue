package com.wemanity.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class OCRReaderTest {

	@Test
    void testReadCharacter() {
        String input = "    _  _     _  _  _  _  _ \n" +
                       "  | _| _||_||_ |_   ||_||_|\n" +
                       "  ||_  _|  | _||_|  ||_| _|\n" +
                       "                            ";
        OCRReader reader = new OCRReader(input);

        String[] expectedCharacter = {" _ ", " _|", "|_ "};
        assertArrayEquals(expectedCharacter, reader.getCharacter(1)); //2
    }
}
