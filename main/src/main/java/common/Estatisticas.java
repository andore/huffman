package common;

import java.lang.reflect.Field;

public class Estatisticas {
	public static long caracteres;
	public static long iteracoes;
	public static long nos;

	public static void imprime() {
		System.out.println("QUANTIDADE DE CARACTERES:" + caracteres);
		System.out.println("QUANTIDADE DE NÓS:" + nos);
		System.out.println("QUANTIDADE DE ITERAÇÕES:" + iteracoes);
	}

	public static void reset() {
		Estatisticas.caracteres = 0;
		Estatisticas.iteracoes = 0;
		Estatisticas.nos = 0;
	}

	public static String getCsv() {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<Estatisticas.class.getDeclaredFields().length; i++) {	
			Field f = Estatisticas.class.getDeclaredFields()[i];
			try {
				sb.append(f.get(f).toString());
			} catch (IllegalArgumentException e) {
				sb.append(' ');
				System.out.println("Erro ao tentar ler valor do campo" + f.getName() + e.getMessage());
			} catch (IllegalAccessException e) {
				sb.append(' ');
				System.out.println("Erro ao tentar ler valor do campo" + f.getName() + e.getMessage());
			}
			if(i<Estatisticas.class.getDeclaredFields().length - 1) 
			{
				sb.append(',');
			}
		}
		sb.append('\n');
		return sb.toString();
	}

	public static String getCabecalhoCsv() {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<Estatisticas.class.getDeclaredFields().length; i++) {
			
			Field f = Estatisticas.class.getDeclaredFields()[i];
			sb.append(f.getName());
			
			if(i<Estatisticas.class.getDeclaredFields().length - 1) 
			{
				sb.append(',');
			}
		}
		sb.append('\n');
		return sb.toString();
	}
}
