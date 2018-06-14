package common;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivo {
	
	private static List<String> listaArquivos;
	
	public static StringBuffer ler(String diretorio) {
		StringBuffer t = new StringBuffer(); 
		try {
			FileReader arq = new FileReader(diretorio);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();

			while (linha != null) {
				t.append(linha);
				linha = lerArq.readLine();
			}

			arq.close();
		} catch (IOException e) {
			System.err.println("Arquivo nao encontrato:" + diretorio);
			System.err.println(e.getStackTrace());
			return null;
		}
		Estatisticas.tamanho_texto = t.length();
		return t;
	}
	
	public static void gravar(String diretorio, String dado) {
	
		try {
			FileWriter arq = new FileWriter(diretorio, true);
		    PrintWriter gravarArq = new PrintWriter(arq);
		    
		    gravarArq.printf(dado);
		    arq.close();
			
		} catch (IOException e) {
			System.err.println("Diretorio nao encontrato:" + diretorio);
			System.err.println(e.getStackTrace());
		}
		
	}
	
	public static void listar(File file) 
	{
		File[] lista;
		if (file.isDirectory())
		{
			lista = file.listFiles();
			for (int i = 0; i < lista.length; i++)
			{
				listar(lista[i]);
			}
		}
		else
		{
			listaArquivos.add(file.getAbsolutePath());
		}
	}

	public static List<String> getListaArquivos(String diretorio)
	{	
		listaArquivos = new ArrayList<>();
		File file = new File(diretorio);
		listar(file);
		return listaArquivos;
	}

}
