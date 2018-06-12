package common;

import java.io.File;

public class ListaDiretorio 
{
	private static File[] lista;
	

	public static void listar(File file) 
	{
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
			System.out.println(file.getName());
		}
	}

	public static void getListaArquivos(String diretorio)
	{	
		File file = new File(diretorio);
		listar(file);
	}
}
