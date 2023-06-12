package 자바강의2023.week11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PerdormanceDemo {
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		LinkedList<Integer> ll = new LinkedList<>();
		
		
		// ArrayList
		long start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			a1.add(0, i);
		}
		long end = System.nanoTime();
		long duration = end - start;
		System.out.println("ArratList로 처리한 시간 : " + duration);
		
		
		// LinkedList
		start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			ll.addFirst(i);
		}
		end = System.nanoTime();
		duration = end - start;
		System.out.println("LinkedList로 처리한 시간 : " + duration);
	}

}
