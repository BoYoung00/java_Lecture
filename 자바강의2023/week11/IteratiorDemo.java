package 자바강의2023.week11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class IteratiorDemo {
	public static void main(String[] args) {
		//Arrays : 자바에서 배열을 쉽게 관리할 수 있도록 하기 위해서 제공되는 클래스
		Collection<String> list = Arrays.asList("다람쥐", "개구리", "나비");
		
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next() + "-");
		System.out.println();
		
		// 반복자 사용하지 않을 경우 for~each 문을 사용할 수도 있음
		for (String s : list) 
			System.out.println(s + "-");
		System.out.println();
		
		// 반복자는 되돌리기 기능이 없음
		while (iterator.hasNext())
			System.out.println(iterator.next() + "+");
		System.out.println();
		
		iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next() + "=");
	}
}
