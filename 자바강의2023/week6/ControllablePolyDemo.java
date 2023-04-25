package 자바강의2023.week6;
public class ControllablePolyDemo {

	public static void main(String[] args) {
		Controllable[] controllable = { new TV(), new Computer() };
		
		for (Controllable c : controllable) 
			printObj(c);
		Controllable.reset();
		
		TV t = (TV) controllable[0];
		
	}
	static void printObj(Controllable c) {
		c.turnOn();
		c.turnOff();
		c.repair();
	}

}
