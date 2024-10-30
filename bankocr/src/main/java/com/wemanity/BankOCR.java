package com.wemanity;

import com.wemanity.domain.AccountFormatter;
import com.wemanity.domain.OCRParser;
import com.wemanity.domain.OCRService;

public class BankOCR {

	public static void main(String[] args) {
		// Exemple d'entrée OCR représentant un numéro de compte
        String input = 
                " _  _  _  _  _  _  _  _  _ \n" +
                "| || || || || || || || || |\n" +
                "|_||_||_||_||_||_||_||_||_|\n" +
                "                           ";

        // Initialisation des composants OCR
        OCRParser parser = new OCRParser();
        AccountFormatter formatter = new AccountFormatter();
        OCRService service = new OCRService(parser, formatter);

        // Traitement de l'entrée et affichage du résultat
        String result = service.processAccount(input);
        System.out.println("Résultat du traitement OCR : " + result);
	}
}
