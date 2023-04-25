package 자바강의2023.week6;

public class ControllableDemo {

	public static void main(String[] args) {
		TV tv = new TV();
		Computer com = new Computer();
		
		tv.remoteOn();
		tv.remoteOff();
		tv.repair(); //디폴트 메서드 (상속 이루어짐)
		
		com.turnOn();
		com.turnOff();
		com.repair(); //디폴트 메서드 (상속 이루어짐)
		
		Controllable.reset(); //인터페이스 이름을 이용하여 static 메서드 호출
		//tv.reset(); //객체 참조 변수를 이용해서 static 메서드 호출 불가
		//com.reset();

	}

}
