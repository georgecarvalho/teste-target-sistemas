package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class FaturamentoComJson {
	
	private static FaturamentoDTO[] converteArquivoJsonParaListaDeObjeto(String path) {
		FaturamentoDTO lista[] = null;
		try {		
			BufferedReader br = new BufferedReader(new FileReader(path));
		    lista = new Gson().fromJson(br, FaturamentoDTO[].class);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		return lista;
	}
	
    public static Double recebeValorMaximoDeArray(Double[] arr) {
    	Double max = arr[0];
        for (int i= 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static Double recebeValorMinimoDeArray(Double[] arr){
    	Double min = arr[0];
        for (int i= 0; i < arr.length; i++) {
            if (arr[i] > 0.0 && arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    private static Double calculaTotalFaturamento(List<Double> listaValores) {
		Double faturamentoTotal = 0.0;
		for (Double valor : listaValores) {
			faturamentoTotal += valor;
		}
		return faturamentoTotal;
	}
    
    private static Integer contaDiasComFaturamentoAcimaDaMedia(List<Double> listaValores, Double mediaFaturamento) {
    	Integer contador = 0;
    	for (Double valor : listaValores) {
			if(valor > mediaFaturamento) {
				contador++;
			}
		}
    	return contador;
    }
	
	public static void main(String[] args) {
		FaturamentoDTO listaFaturamento[] = null;
		String path = new File("src/resources/dados.json").getAbsolutePath();
		listaFaturamento = FaturamentoComJson.converteArquivoJsonParaListaDeObjeto(path);
		
		Double[] valores = new Double[listaFaturamento.length];
		
		for (int i = 0; i < listaFaturamento.length; i++) {
			valores[i] = listaFaturamento[i].getValor();
		}
		
		System.out.println("Valor mínimo de faturamento: " + recebeValorMinimoDeArray(valores));
		System.out.println("Valor máximo de faturamento: " + recebeValorMaximoDeArray(valores));
		
		List<Double> listaValores = new ArrayList<>();
		for (FaturamentoDTO itemFaturamento : listaFaturamento) {
			if(itemFaturamento.getValor() > 0.0) {
				listaValores.add(itemFaturamento.getValor());
			}	
		}
		
		Double faturamentoTotal = calculaTotalFaturamento(listaValores);
		Double mediaFaturamento = faturamentoTotal/listaValores.size();
		
		System.out.println("Faturamento total: " + faturamentoTotal);
		System.out.println("Média de faturamento: " + mediaFaturamento);
		System.out.println("Número de dias acima da média: " + contaDiasComFaturamentoAcimaDaMedia(listaValores, mediaFaturamento));
	}
}
