package 자바강의2023.week5;

public class AbstractClassDemo {

	public static void main(String[] args) {
		// Shape s = new Shape();
		
		Rectangle r = new Rectangle(3, 4);
		r.draw();
		System.out.printf("사각형의 넓이는 %.1f\n", r.findArea());
		
		Shape s = new Circle(3);
		s.draw();
		System.out.printf("원의 넓이는 %.1f\n", s.findArea());
	}

}
