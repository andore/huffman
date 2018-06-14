package common;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Util {

	public static PriorityQueue<No> convertMapQueue(Map<Character, Integer> m) {
		Comparator<Character> comparator = new ComparaFrequencia((HashMap<Character, Integer>) m);
		ComparadorFrequenciaNo comparaNo = new ComparadorFrequenciaNo();

		PriorityQueue<No> q = new PriorityQueue<No>(comparaNo);

		TreeMap<Character, Integer> mapaOprdenado = new TreeMap<Character, Integer>(comparator);
		mapaOprdenado.putAll(m);

		Set<Entry<Character, Integer>> set = mapaOprdenado.entrySet();
		Iterator<Entry<Character, Integer>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry<Character, Integer> mentry = iterator.next();
			No n = new No();
			n.caractere = (char) mentry.getKey();
			n.frequencia = (int) mentry.getValue();

			q.add(n);
		}

		return q;
	}

	public static Map<Character, Integer> getFrequencia(StringBuffer t) {
		Map<Character, Integer> mapa = new HashMap<Character, Integer>();
		for (char c : t.toString().toCharArray()) {
			if (mapa.containsKey(c)) {
				mapa.put(c, mapa.get(c) + 1);
			} else {
				mapa.put(c, 1);
			}
		}		
		Estatisticas.caracteres = mapa.size();
		return mapa;
	}

	public static Map<Character, String> extraiCodigoArvore(No root) {
		No p = root;
		Stack<No> travStack = new Stack<No>();
		Map<Character, String> codigos = new HashMap<>();

		if (p != null) {
			travStack.push(p);
			while (!travStack.isEmpty()) {
				p = travStack.pop();

				if (p.caractere != 0) {
					codigos.put(p.caractere, p.codigo);
				}

				if (p.direita != null) {
					if (p.codigo == null) {
						p.codigo = "";
					}
					p.direita.codigo = p.codigo + "1";
					travStack.push(p.direita);
				}
				if (p.esquerda != null) {
					p.esquerda.codigo = p.codigo + "0";
					travStack.push(p.esquerda);
				}
				Estatisticas.nos++;
			}
		}
		
		return codigos;
	}

	public static void imprime(Map<Character, String> c) {
		Comparator<Character> comparator = new ComparaComprimentoCodigo((HashMap<Character, String>) c);
		TreeMap<Character, String> mapaOprdenado = new TreeMap<Character, String>(comparator);
		mapaOprdenado.putAll(c);
		
		Set<Entry<Character, String>> set = mapaOprdenado.entrySet();
		Iterator<Entry<Character, String>> iterator = set.iterator();
		
		while (iterator.hasNext()) {
			Entry<Character, String> mentry = iterator.next();
			System.out.println(mentry.getKey() + "=" + mentry.getValue());
		}
	}
}
