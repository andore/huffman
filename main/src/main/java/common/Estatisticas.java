package common;

import java.lang.reflect.Field;

public class Estatisticas {
	public static long caracteres;
	public static long iteracoes;
	public static long nos;
	public static long tamanho_texto;

	public static void imprime() {
		for (int i=0; i<Estatisticas.class.getDeclaredFields().length; i++) {	
			Field f = Estatisticas.class.getDeclaredFields()[i];
			try {
				System.out.println(f.getName().toUpperCase() + ":" + f.get(f).toString());
			} catch (IllegalArgumentException e) {
				System.out.println("Erro ao tentar ler valor do campo" + '\n' + f.getName() + e.getMessage());
			} catch (IllegalAccessException e) {
				System.out.println("Erro ao tentar ler valor do campo" + '\n' + f.getName() + e.getMessage());
			}
		}
		
//		System.out.println("QUANTIDADE DE CARACTERES:" + caracteres);
//		System.out.println("QUANTIDADE DE NÓS:" + nos);
//		System.out.println("QUANTIDADE DE ITERAÇÕES:" + iteracoes);
//		System.out.println("QUANTIDADE DE ITERAÇÕES:" + tamanhoTexto);
	}

	public static void reset() {
		for (int i=0; i<Estatisticas.class.getDeclaredFields().length; i++) {	
			Field f = Estatisticas.class.getDeclaredFields()[i];
			try {
				f.setInt(f, 0);
			} catch (IllegalArgumentException e) {			
				System.out.println("Erro ao tentar zerar valor do campo" + f.getName() + '\n' + e.getMessage());
			} catch (IllegalAccessException e) {
				System.out.println("Erro ao tentar zerar valor do campo" + f.getName() + '\n'+ e.getMessage());
			}
		}
	}

	public static String getCsv() {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<Estatisticas.class.getDeclaredFields().length; i++) {	
			Field f = Estatisticas.class.getDeclaredFields()[i];
			try {
				sb.append(f.get(f).toString());
			} catch (IllegalArgumentException e) {
				sb.append(' ');
				System.out.println("Erro ao tentar ler valor do campo" + '\n' + f.getName() + e.getMessage());
			} catch (IllegalAccessException e) {
				sb.append(' ');
				System.out.println("Erro ao tentar ler valor do campo" + '\n' + f.getName() + e.getMessage());
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
			sb.append(f.getName().toUpperCase());
			
			if(i<Estatisticas.class.getDeclaredFields().length - 1) 
			{
				sb.append(',');
			}
		}
		sb.append('\n');
		return sb.toString();
	}
}
