package 자바강의2023.week4;

public class Cylinder extends Circle{
	private String color;
	
	public Cylinder(String color) {
		this.color = color;
	}
	public void findColor() {
		System.out.println(color + " 공이다.");
	}
//	protected void findRadius() {
//		System.out.println("메서드 오버라이딩");
//	}
	public void findArea() {
		System.out.println("넓이는 2*(π*반지름*반지름) + 2*(π*반지름*높이)이다.");
		super.findArea();
	}
}
