package 자바강의2023.week5;

class Person {
	String name = "사람";
	
	void whoami() {
		System.out.println("나는 사람이다.");
	}
}

class Student extends Person {
	int number = 7;
	
	void work() {
		System.out.println("나는 공부한다.");
	}
}

public class UpcastDemo {
	public static void main(String[] args) {
		Student s = new Student();
		
		System.out.println(s.name);
		System.out.println(s.number);
		
		// Student d = new Person();
		
		Person p = s;
		
		// p.number = 1;
		// p.work();
		p.whoami();
		
		// 부모클래스 타입의 참조변수가 참조하고 있는 자식 타입의 객체를 원래 타입의 객체로 만들경우 강제 형변환을 이용
		s=(Student)p;
		System.out.println(s.name);
		System.out.println(s.number);
	}
}


