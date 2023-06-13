package 자바강의2023.week12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleDemo {

	public static void main(String[] args) {
		List<Character> list = new ArrayList<>();
		
		for (char c = 'A'; c <= 'G'; c++) 
			list.add(c);
		
		System.out.println("최초 리스트 :\t" + list);
		Collections.rotate(list, 3); // 뒤에서 3번째부터 돌리기
		System.out.println("돌린 리스트 :\t" + list);
		Collections.shuffle(list); // 무작위로 섞기
		System.out.println("섞은 리스트 :\t" + list);
	}

}
