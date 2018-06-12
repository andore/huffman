package common;

import java.util.Comparator;
import java.util.HashMap;

public class ComparaFrequencia implements Comparator<Character>{
	 
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
	public ComparaFrequencia(HashMap<Character, Integer> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(Character s1, Character s2) {
		if(map.get(s1) < map.get(s2)){
			return -1;
		}else{
			return 1;
		}	
	}
}