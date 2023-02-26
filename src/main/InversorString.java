package main;

import java.util.Scanner;

public class InversorString {
	public static String inverte(String texto) {
		String novaString = "";
		char ch;
		
		for (int i = 0; i < texto.length(); i++) {
			ch = texto.charAt(i);
			novaString = ch + novaString;
		}
		return novaString;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inversor de Strings:");
		String texto = sc.nextLine();
		System.out.println(InversorString.inverte(texto));
		System.out.println("\n");
	}

}
