package core;

import java.util.List;

import common.Estatisticas;
import common.GerenciadorArquivo;

public class Main {
	public static void main(String[] args) {
		
		List<String> listaArquivos = GerenciadorArquivo.getListaArquivos("D:\\Projetos\\huffman\\main\\src\\main\\resources\\arquivos");
		
		for(String arquivo: listaArquivos) 
		{
			System.out.println("-----------------------------------------");
			System.out.println("PROCESSANDO ARQUIVO " + arquivo);
			System.out.println("-----------------------------------------");
			StringBuffer texto = GerenciadorArquivo.ler(arquivo);
			new Hufman().codifica(texto);
			Estatisticas.imprime();
			
			if(GerenciadorArquivo.ler("D:\\Projetos\\huffman\\main\\src\\main\\resources\\estatiscas.csv")==null) 
			{
				GerenciadorArquivo.gravar("D:\\Projetos\\huffman\\main\\src\\main\\resources\\estatiscas.csv", Estatisticas.getCabecalhoCsv() );
			}
			
			GerenciadorArquivo.gravar("D:\\Projetos\\huffman\\main\\src\\main\\resources\\estatiscas.csv", Estatisticas.getCsv());
			System.out.println("-----------------------------------------\n");
			Estatisticas.reset();
		}
	}
}
