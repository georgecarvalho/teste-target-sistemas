package main;

import java.util.ArrayList;
import java.util.List;

public class Faturamento {
	private String estado;
	private double valor;
	
	public Faturamento(String estado, double valor) {
		this.estado = estado;
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public double getValor() {
		return valor;
	}
	
	public static void main(String[] args) {
		List<Faturamento> arrayFaturamento = new ArrayList<>();
		arrayFaturamento.add(new Faturamento("SP", 67836.43));
		arrayFaturamento.add(new Faturamento("RJ", 36678.66));
		arrayFaturamento.add(new Faturamento("MG", 29229.88));
		arrayFaturamento.add(new Faturamento("ES", 27165.48));
		arrayFaturamento.add(new Faturamento("OUTROS", 19849.53));
		
		double faturamentoTotal = 0;
		
		for (Faturamento faturamento : arrayFaturamento) {
			faturamentoTotal += faturamento.getValor();
		}
		
		System.out.println("Faturamento total: RS " + faturamentoTotal);
		
		for (Faturamento faturamento : arrayFaturamento) {
			System.out.println("Estado: " + faturamento.getEstado());
			System.out.printf("Porcentagem: %.2f%% %n", (faturamento.getValor()/faturamentoTotal) * 100);
		}
	}
}
