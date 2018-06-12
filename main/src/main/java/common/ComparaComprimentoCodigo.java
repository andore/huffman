package common;

import java.util.Comparator;
import java.util.HashMap;

public class ComparaComprimentoCodigo implements Comparator<Character>{
	 
	HashMap<Character, String> map = new HashMap<Character, String>();
 
	public ComparaComprimentoCodigo(HashMap<Character, String> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(Character s1, Character s2) {
		if(map.get(s1).length() < map.get(s2).length()){
			return -1;
		}else{
			return 1;
		}	
	}
}