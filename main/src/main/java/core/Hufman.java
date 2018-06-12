package core;

import java.util.Map;
import java.util.PriorityQueue;

import common.Estatisticas;
import common.No;
import common.Util;

public class Hufman {
	private No x, y;
	private int n, i;
	private PriorityQueue<No> Q;
	
	public void codifica(StringBuffer texto) 
	{
		Map<Character, Integer> C = Util.getFrequencia(texto);
		No arvoreHuffman = HUFFMAN(C);
		Map<Character, String> caracteresCodificados = Util.extraiCodigoArvore(arvoreHuffman);
		//Util.imprime(caracteresCodificados);
		
	}
		
	private No HUFFMAN(Map<Character, Integer> C) 
	{
		n = C.size();
		Estatisticas.iteracoes++;
		
		Q = Util.convertMapQueue(C);
		Estatisticas.iteracoes++;
		
		for (i=0; i<n-1; i++) 
		{
			Estatisticas.iteracoes++;
			
			No z = new No();
			Estatisticas.iteracoes++;
			
			z.esquerda = x = Q.poll();
			Estatisticas.iteracoes++;
			
			z.direita = y = Q.poll();
			Estatisticas.iteracoes++;
			
			z.frequencia = x.frequencia + y.frequencia;
			Estatisticas.iteracoes++;
			
			Q.add(z);
			Estatisticas.iteracoes++;
		}
		
		Estatisticas.iteracoes++;
		return Q.poll();
	}
}