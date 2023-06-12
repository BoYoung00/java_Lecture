package 자바강의2023.week12;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Set<String> s = Set.of("포도", "수박", "사과", "키위", "망고");
		HashSet<String> h = new HashSet<>(s);
		System.out.println(h);
		// 정렬 상태로 생성
		TreeSet<String> f = new TreeSet<>(s);
		System.out.println(f);
		
		System.out.println(f.first());
		System.out.println(f.last());
		// 사과보다 앞에 있는 원소
		System.out.println(f.lower("사과"));
		// 사과보다 뒤에 있는 원소
		System.out.println(f.higher("사과"));
	}
}
