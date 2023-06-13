package 자바강의2023.week11;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
		System.out.println(q.poll()); // 맨 앞 값 삭제
		q.offer("사과"); // 값 추가, 추가 성공 시 true 반환, 실패시 false
		System.out.println("바나나를 추가했나요? " + q.offer("바나나"));
		
		try {
			q.add("체리"); // 값 추가, 추가 성공 시 true 반환, 실패시 오류
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
		System.out.println("헤드 엿보기 : " + q.peek()); // 맨 처음 넣은 값 출력, 없으면 null 반환
		
		String head = null;
		
		try {
			head = q.remove();
			System.out.println(head + " 제거하기");
			System.out.println("새로운 헤드 : " + q.element()); // 맨 앞 값 반환, 없으면 오류
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		head = q.poll();
		System.out.println(head + "제거하기");
		System.out.println("새로운 헤드 : " + q.peek());
		
		System.out.println("체리를 포함하고 있나요? " + q.contains("체리"));
		System.out.println("체리를 포함하고 있나요? " + q.contains("사과"));
	}
}
