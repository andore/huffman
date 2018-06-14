package aula11;

import common.Estatisticas;

public class Fatorial {
	
	private static int FAT[];
	
	public static void main(String[] args)
	{
		
		int n=17;
		System.out.println("------------------");
		System.out.println("FATORIAL COMUM");
		System.out.println("------------------");
		for(int i=1; i<n; i++) 
		{
			System.out.println("FATORIAL " + (i) + ":" + fatorial(i));
		}
		System.out.print('\n');
		Estatisticas.imprime();
		Estatisticas.reset();
		System.out.println("------------------\n");
		
		System.out.println("------------------");
		System.out.println("FATORIAL PROGRAMACAO DINAMICA");
		System.out.println("------------------");
		FAT = new int [999];
		for(int i=1; i<n; i++) 
		{
			System.out.println("FATORIAL " + (i) + ":" + fatorialDinamico(i));
		}
		System.out.print('\n');
		Estatisticas.imprime();
		Estatisticas.reset();
		System.out.println("------------------\n");
	}
	
	public static int fatorialDinamico(int n)
	{
		Estatisticas.iteracoes++;
		if(n==0)
		{
			Estatisticas.iteracoes++;
			return 1;
		}
		else
		{
			Estatisticas.iteracoes++;
			if(FAT[n] != 0)
			{
				Estatisticas.iteracoes++;
				return FAT[n];
			}
			else 
			{
				Estatisticas.iteracoes++;
				return FAT[n] = n * fatorialDinamico(n-1);
			}
		}
	}
	
	public static int fatorial(int n)
	{
		Estatisticas.iteracoes++;
		if(n==0)
		{
			Estatisticas.iteracoes++;
			return 1;
		}
		else
		{
			Estatisticas.iteracoes++;
			return n*fatorial(n-1);
		}
	}

}
