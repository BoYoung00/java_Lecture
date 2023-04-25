package 자바강의2023.week5;
class Vehicle {
	void whoami() {
		System.out.println("나는 탈 것이다.");
	}
}

class Car extends Vehicle {
	void whoami() {
		System.out.println("나는 자동차이다.");
	}
}

class SportsCar extends Car {
	void whoami() {
		System.out.println("나는 스포츠 자동차이다.");
	}
}

public class PolymorDemo {

	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = new Vehicle();
		vehicles[1] = new Car();
		vehicles[2] = new SportsCar();
		
		PolymorDemo p = new PolymorDemo();
		
		for (Vehicle v : vehicles)
			p.prontWhami(v);

	}
	void prontWhami(Vehicle v) {
		v.whoami();
	}

}
