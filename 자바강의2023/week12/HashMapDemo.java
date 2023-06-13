package 자바강의2023.week12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


// Map : key, value
// 순차X
// HashMap : 많은 양의 데이터 검색 가능
// Map.Entry<> : Map 형태의 인터페이스 만듦
public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(36, "basick"); // 추가
		map.put(40, "Koonta");
		map.put(21, "Layone");
		
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet(); // 해당 맵에 포함된 모든 매핑을 Set 객체로 반환함.
		for (Entry n : entrySet)
			System.out.println(n.getKey() + " : " + n.getValue());
		System.out.println();
		
		Set<Integer> keySet = map.keySet(); // 해당 맵에 포함되어 있는 모든 키로 만들어진 Set 객체를 반환함.
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
