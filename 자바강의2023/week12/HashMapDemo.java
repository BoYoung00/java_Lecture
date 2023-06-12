package 자바강의2023.week12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(36, "basick");
		map.put(40, "Koonta");
		map.put(21, "Layone");
		
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		for (Entry n : entrySet)
			System.out.println(n.getKey() + " : " + n.getValue());
		System.out.println();
		
		Set<Integer> keySet = map.keySet();
		//for - each를 통한 순차적 접근
		for (Integer k : keySet) 
			System.out.println(k + " : " + map.get(k) + "\t");
		System.out.println();
		
		for(Iterator<Integer> itr = keySet.iterator(); itr.hasNext();) {
			Integer key = itr.next();
			System.out.println(key + " : " + map.get(key));
		}
	}
}
