package 자바강의2023.week12;

import java.util.Map;
import java.util.Scanner;

public class JuiceMap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> f = Map.of("사과", 500, "딸기", 300, "포도", 600);
		
		System.out.println("음료 종류 : 사과, 딸기, 포도");
		while (true) {
			System.out.print("가격을 검색할 음료이름 (0 : 종료) => ");
			String input = in.next();
			
			if (input.equals("0"))
				break;
			
			if (f.containsKey(input))
				System.out.println(input + " 주스의 가격 : " + f.get(input));		
		}
	}
}
