package common;

import java.util.Comparator;

public class ComparadorFrequenciaNo implements Comparator<No>{

	@Override
	public int compare(No o1, No o2) {
		//Estatisticas.iteracoes++;
		if(o1.frequencia < o2.frequencia){
			return -1;
		}else{
			return 1;
		}	
	}

}
