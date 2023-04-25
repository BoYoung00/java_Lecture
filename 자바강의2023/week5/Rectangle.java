package 자바강의2023.week5;

class Rectangle extends Shape {
	int width, height;
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	@Override
	void draw() {
		System.out.println("사각형을 그리다.");
	}
	
	public double findArea() {
		return width * height;
	}
}
