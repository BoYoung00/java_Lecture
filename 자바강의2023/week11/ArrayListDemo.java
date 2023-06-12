package 자바강의2023.week11;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<String> list = List.of("그랜저", "소나타", "아반테", "제네시스", "소울");
		
		System.out.println(list.indexOf("소나타"));
		System.out.println(list.contains("싼타페"));
		
		// List타입을 이용하여 ArrayList 객체를 생성
		List<String> cars1 = new ArrayList<>(list);
		cars1.add("싼타페");
		
		//forEach : Collection 인터페이스에서 제공해주는 디폴트 메서드
		//람다식 표현
		cars1.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		List<String> cars2 = new ArrayList<>(list);
		cars2.remove("제네시스");
		cars2.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		System.out.println(cars1.containsAll(cars2));
		
		cars1.removeIf(c -> c.startsWith("소"));
		cars1.replaceAll(s -> "뉴" + s);
		cars1.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		cars1.clear();
		System.out.println(cars1.isEmpty());
	}
}
