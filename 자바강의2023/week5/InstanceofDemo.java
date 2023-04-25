package 자바강의2023.week5;

public class InstanceofDemo {

	public static void main(String[] args) {
		InstanceofDemo d = new InstanceofDemo();
		
		Student s = new Student();
		Person p = new Person();
		
		System.out.println(s instanceof Person);
		System.out.println(s instanceof Student);
		System.out.println(p instanceof Student);
		
		d.downcast(s);
	}
	//메서드 호출시 인자의 전달 과정에서도 자동 형변환이 이루어짐
	void downcast(Person p) {
		if (p instanceof Student) {
			Student s = (Student) p;
			System.out.println("ok, 하향 타입 변환");
		}
		
	}

}
