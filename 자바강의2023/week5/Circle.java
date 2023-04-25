package 자바강의2023.week5;

class Circle extends Shape{
	int radius;

	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	void draw() {
		System.out.println("원을 그리다.");	
	}
	
	@Override
	public double findArea() {
		return pi * radius * radius;
	}
}
