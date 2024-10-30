package com.wemanity.domain;

public class OCRReader {

	private final String[] lines;

	public OCRReader(String input) {
        this.lines = input.split("\n");
    }

    public String[] getCharacter(int index) {
        int start = index * 3;
        return new String[]{
                lines[0].substring(start, start + 3),
                lines[1].substring(start, start + 3),
                lines[2].substring(start, start + 3)
        };
    }

	public int getTotalDigits() {
		return lines[0].length() / 3;
	}

}
