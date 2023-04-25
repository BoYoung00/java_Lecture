package 자바강의2023.week4;

public class InheritenceDemo2 {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		Cylinder c2 = new Cylinder("파란색");
		
		System.out.println("원 : ");
		c1.findRadius();
		c1.findArea();
//		c1.secret();
		
		System.out.println("\n실린더 : ");
		c2.findRadius();
		c2.findColor();
		c2.findArea();
//		c2.secret();
	}
}
