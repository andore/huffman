package core;

import java.util.Date;
import java.util.List;

import common.Estatisticas;
import common.GerenciadorArquivo;

public class Main {
	private final static String DIRETORIO_ARQUIVOS = "D:\\Projetos\\huffman\\main\\src\\main\\resources\\arquivos";
	private final static String DIRETORIO_ESTATISTICAS = "D:\\Projetos\\huffman\\main\\src\\main\\resources\\estatisticas\\";
	
	public static void main(String[] args) {
		String nomeArquivoEstatistica = "estatiscas_";
		List<String> listaArquivos = GerenciadorArquivo.getListaArquivos(DIRETORIO_ARQUIVOS);
		nomeArquivoEstatistica += new Date().getTime() + ".csv"; 
		
		for(String arquivo: listaArquivos) 
		{
			System.out.println("-----------------------------------------");
			System.out.println("PROCESSANDO ARQUIVO " + arquivo);
			System.out.println("-----------------------------------------");
			StringBuffer texto = GerenciadorArquivo.ler(arquivo);
			new Hufman().codifica(texto);
			Estatisticas.imprime();
			
			if(GerenciadorArquivo.ler(DIRETORIO_ESTATISTICAS + nomeArquivoEstatistica)==null) 
			{
				GerenciadorArquivo.gravar(DIRETORIO_ESTATISTICAS  + nomeArquivoEstatistica, Estatisticas.getCabecalhoCsv() );
			}
			
			GerenciadorArquivo.gravar(DIRETORIO_ESTATISTICAS + nomeArquivoEstatistica, Estatisticas.getCsv());
			System.out.println("-----------------------------------------\n");
			Estatisticas.reset();
		}
	}
}
