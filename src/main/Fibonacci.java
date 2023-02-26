package main;

import java.util.Scanner;

public class Fibonacci {
	static Integer calcula(Integer n) {
		return (n < 2) ? n : calcula(n - 1) + calcula(n - 2);
	}

	static String buscaNumeroNaSequenciaFibonacci(Integer numero) {
		for (int i = 0; i < numero; i++) {
			Integer resultado = Fibonacci.calcula(i);
			
			if(numero.equals(resultado)) {
				return "O n�mero " + resultado + " pertence � sequ�ncia Fibonacci";
			}
		}
		return "O n�mero n�o pertence � sequ�ncia Fibonacci";
	}
	
	public static void main(String[] args) {
		System.out.println("Digite um numero");
		Scanner sc = new Scanner(System.in);
		Integer numero = sc.nextInt();
		System.out.println(Fibonacci.buscaNumeroNaSequenciaFibonacci(numero));
	}
}
