package 자바강의2023.week12;

import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> f = Map.of("사과", 5, "바나나", 3, "포도", 10, "딸기", 1);
		System.out.println(f.size() + "종류의 과일이 있습니다.");
		System.out.println(f);
		
		for (String key : f.keySet()) {
			System.out.println(key + "가 " + f.get(key) + "개 있습니다.");
		}
		
		System.out.println();
		String key = "바나나";
		if (f.containsKey(key))
			System.out.println(key + "가 " + f.get(key) + "개 있습니다.");
		f.forEach((k,n)->System.out.println(k+"("+n+")"));
		
		/*
		//Map.of()에 의해 생성된 객체는 불변
		f.put("키위", 2);
		f.remove("사과");
		f.clear();
		*/
	}
}
