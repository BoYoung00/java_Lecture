package 자바강의2023.week7;


public class ObjectMethodDemo {
	public static void main(String[] args) {
		Mouse m1 = new Mouse("Logitech");
		Mouse m2 = new Mouse("Logitech");
		Mouse m3 = m1;
		Keyboard k1 = new Keyboard("Microsoft");
		Keyboard k2 = new Keyboard("Microsoft");
		
		//Mouse 타입 객체는 Object 클래스에서 제공하는 toString 메서드 사용
		System.out.println(m1.toString());
		System.out.println(m1);
		
		// Keyboard 타입 객체는 오버라이딩된 toString 메서드 사용
		System.out.println(k1.toString());
		System.out.println(k1);
		
		//Object 클래스의 equals 메서드는 동일한 객체인지를 판단
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		
		// Keyboard 타입 객체의 오버라이딩된 equals 메서드를 사용
		System.out.println(k1.equals(k2));
		
		
	}
}
